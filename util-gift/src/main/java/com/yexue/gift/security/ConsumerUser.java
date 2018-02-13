package com.yexue.gift.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 登录用户信息
 *
 * @ClassName: ConsumerUser
 * @Description:登录用户信息
 * @author: maxf
 * @date: 2017年11月22日 下午4:39:45
 */
public class ConsumerUser extends User {
    private static final long serialVersionUID = 1L;

    /**
     * 消费者用户主键ID
     */
    private String id;
    /**
     * 用户code
     */
    private String code;
    /**
     * umeng token
     */
    private String umengToken;
    /**
     * <pre>
     * 登录客户端
     * ANDROID
     * IOS
     * </pre>
     */
    private String app;

    public ConsumerUser(String username, String password, boolean enabled, boolean accountNonExpired,
                        boolean credentialsNonExpired, boolean accountNonLocked,
                        Collection<? extends GrantedAuthority> authorities,
                        String id, String code, String umengToken, String app) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.code = code;
        this.umengToken = umengToken;
        this.app = app;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");

        sb.append("id: ").append(this.id).append("; ");
        sb.append("code: ").append(this.code).append("; ");
        sb.append("umengToken: ").append(this.umengToken).append("; ");
        sb.append("app: ").append(this.app);

        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUmengToken() {
        return umengToken;
    }

    public void setUmengToken(String umengToken) {
        this.umengToken = umengToken;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }
}
