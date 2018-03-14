package com.yexue.gift.security;

import com.yexue.gift.consts.RedisConsts;
import com.yexuejc.util.base.autoconfigure.MutiRedisAutoConfiguration;
import com.yexuejc.util.base.constant.RespsConstant;
import com.yexuejc.util.base.http.Resps;
import com.yexuejc.util.base.util.JsonUtil;
import com.yexuejc.util.base.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Security Web 配置
 *
 * @ClassName: SecurityConfig
 * @Description:Security Web 配置
 * @author: maxf
 * @date: 2017年11月22日 下午4:40:22
 */
@EnableWebSecurity(debug = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String CONSUMER_USERS_BY_USERNAME_QUERY = "";
    private static final String CONSUMER_AUTHORITIES_BY_USERNAME_QUERY = "";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier(MutiRedisAutoConfiguration.BEAN_REDIS_TEMPLATE0)
    private RedisTemplate<Object, Object> redisTemplate0;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new ConsumerJdbcDaoImpl(jdbcTemplate, CONSUMER_USERS_BY_USERNAME_QUERY,
                CONSUMER_AUTHORITIES_BY_USERNAME_QUERY)).passwordEncoder(new Md5PasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.servletApi().disable();
        http.requestCache().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.securityContext().securityContextRepository(new ConsumerSecurityContextRepository(redisTemplate0));
        http.formLogin().successHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                String token = JwtUtil.compact(new ConsumerToken(authentication.getName()));
                ConsumerUser user = (ConsumerUser) authentication.getPrincipal();
                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                List<String> roles = new ArrayList<>();
                if (authorities != null && authorities.size() > 0) {
                    for (GrantedAuthority g : authorities) {
                        roles.add(g.getAuthority());
                    }
                }

                Map<String, Object> m = new HashMap<String, Object>(16);
                m.put("username", user.getUsername());
                m.put("token", token);
                m.put("roles", roles);
                m.put("id", user.getId());
                m.put("code", user.getCode());

                redisTemplate0.opsForHash().putAll(RedisConsts.PREFIX_CONSUMER_SESSION + "-" + user.getUsername(), m);

                response.setContentType("application/json;charset=UTF-8");
                Resps<String> resps = Resps.success(RespsConstant.MSG_SUCCESS_HTTP);
                resps.setData(token);
                response.getWriter().write(JsonUtil.obj2Json(resps));
                response.getWriter().close();
            }
        }).failureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                AuthenticationException exception) throws IOException,
                    ServletException {
                response.setContentType("application/json;charset=UTF-8");
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                Resps<Object> resps = new Resps<Object>();
                if (exception instanceof DisabledException) {
                    resps = Resps.error("", "该账户已被禁用");
                } else if (exception instanceof AccountExpiredException) {
                    resps = Resps.error("", "该帐户已过期");
                } else if (exception instanceof CredentialsExpiredException) {
                    resps = Resps.error("", "登陆凭证已经过期，请重新登陆");
                } else if (exception instanceof LockedException) {
                    resps = Resps.error("", "该账户被锁定");
                } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
                    resps = Resps.error("", "身份验证凭证未找到");
                } else if (exception instanceof BadCredentialsException) {
                    resps = Resps.error("", "密码错误");
                } else if (exception instanceof UsernameNotFoundException) {
                    resps = Resps.error("", "该账户名不存在");
                } else {
                    resps = Resps.error("", "登录时发生错误，请联系系统管理员");
                }
                response.getWriter().write(JsonUtil.obj2Json(resps));
                response.getWriter().close();
            }
        });

        // 权限控制
        http.authorizeRequests().antMatchers(
                "/cashout/hs1/notify-back",
                "/cashout/hsc4/notify-back",
                "/cashout/hsb2/front-notify-url",
                "/bmop/flow/notify",
                "/wxpay/notify",
                "/alipay/notify",
                "/bmop/mobile/notify",
                "/bmop/life/notify",
                "/cashout/hsb2/back-notify-url").permitAll();
        http.authorizeRequests().antMatchers(
                "/cashout/**",
                "/my/getIdent",
                "/my/addBankCard",
                "/my/addBankCard/sendSms",
                "/my/addDebitBankCard",
                "/my/addDebitBankCard/sendSms",
                "/my/bankcards").hasRole("CONSUMER_REAL");
        http.authorizeRequests().antMatchers("/circle/level-up").hasAnyRole("CONSUMER_REAL", "CONSUMER_ACTIVATED");
        http.authorizeRequests().antMatchers(
                "/my/**",
                "/wallet/**",
                "/circle/**",
                "/cost/**",
                "/gift/**",
                "/bmop/**").authenticated();

        // 登出处理。
        http.logout().logoutSuccessHandler((request, response, authentication) -> {
            redisTemplate0.delete(RedisConsts.PREFIX_CONSUMER_SESSION + "-" + authentication.getName());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JsonUtil.obj2Json(Resps.success(RespsConstant.MSG_SUCCESS_HTTP)));
            response.getWriter().close();
        });

        // 未登录，却访问需要登录的接口时的处理
        http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(401);
            Resps<Object> resps = new Resps<Object>();
            response.getWriter().write(JsonUtil.obj2Json(Resps.error("您尚未登陆！")));
            response.getWriter().close();
        });
        // 已登录，但当前用户没有访问的某个接口的权限时的处理
        http.exceptionHandling().accessDeniedHandler((request, response, accessDeniedException) -> {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(401);
            response.getWriter().write(JsonUtil.obj2Json(JsonUtil.obj2Json(Resps.error("您无权访问该资源！"))));
            response.getWriter().close();
        });
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 不需要经过SpringSecurity的过滤器的URLs
        // web.ignoring();
    }

}
