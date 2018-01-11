package com.yexuejc.util.base.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.yexuejc.util.base.util.DateUtil;
import com.yexuejc.util.base.util.LogUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * WebMvc相关配置
 *
 * @PackageName: com.yexuejc.util.base.http
 * @Description:
 * @author: maxf
 * @date: 2018/1/11 19:51
 */
@Configuration
@ConditionalOnWebApplication
public class WebAutoConfiguration extends WebMvcConfigurerAdapter {
    /**
     * 重写jsonConverter参数
     *
     * @param objectMapper
     * @return
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(ObjectMapper objectMapper) {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(DateUtil.DATE_TIME_FORMAT);
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }

    /**
     * 全局异常处理
     */
    @ControllerAdvice
    static class GlobalExceptionHandler {
        private static final String ERROR_MSG = "系统错误，请联系管理员";

        /**
         * 出现异常时用于返回Json数据
         *
         * @param e
         * @return
         */
        @ExceptionHandler(value = Throwable.class)
        @ResponseBody
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public Resps<Object> jsonErrorHandler(Throwable e) {
            LogUtil.exceptionLogger.error(e.getMessage(), e);
            return Resps.error(ERROR_MSG);
        }
    }
}
