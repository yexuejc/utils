package com.yexuejc.util.redis.service;

import com.yexuejc.util.redis.autoconfigur.MutiRedisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @PackageName: com.yexuejc.util.redis.service
 * @Description:
 * @author: maxf
 * @date: 2018/1/8 11:39
 */
@Service(value = "redisSrvImpl")
public class Redis1SrvImpl extends RedisDefSrvImpl {
    public static String PREFIX_CONSUMER_FLOW_SIGN_UP = "consumer-flow-sign-up";
    public static String PREFIX_CONSUMER_FLOW_FIND_PWD = "consumer-flow-find-pwd";
    public static String PREFIX_CONSUMER_FLOW_CASHOUT = "consumer-flow-cashout";
    public static String PREFIX_CONSUMER_SMS_SIGN_UP = "consumer-sms-sign-up";
    public static String PREFIX_CONSUMER_SMS_LOGIN_PWD = "consumer-sms-login-pwd";
    public static String PREFIX_CONSUMER_SMS_PAY_PWD = "consumer-sms-pay-pwd";
    public static String PREFIX_CONSUMER_SMS_CASHOUT = "consumer-sms-cashout";
    public static String PREFIX_CONSUMER_SMS_BANK_CARD = "consumer-sms-bank-card";
    public static String PREFIX_CONSUMER_SMS_DEPOSIT_CARD = "consumer-sms-deposit-card";
    public static final String PREFIX_CONSUMER_SESSION = "consumer-session";


    @Autowired
    @Qualifier(MutiRedisAutoConfiguration.BEAN_REDIS_TEMPLATE1)
    RedisTemplate<Object, Object> redisTemplate1;


    @Override
    public List<Map<Object, Object>> getRedisAll() {
        List<Map<Object, Object>> list = new ArrayList<>();
        redisTemplate1.afterPropertiesSet();
        Set<Object> result = redisTemplate1.keys("*");
        for (Object object : result) {
            if (object instanceof String) {
                Map<Object, Object> pmap = new HashMap<>();
                Map<Object, Object> item = redisTemplate1.opsForHash().entries(object);
                pmap.put(object,item);
                list.add(pmap);
            }
        }
        return list;
    }

    /**
     * 根据key 获取redis value(Map)
     *
     * @param key
     * @return
     */
    @Override
    public Map<Object, Object> getRedis4Key(String key) {
        redisTemplate1.afterPropertiesSet();
        Map<Object, Object> map = redisTemplate1.opsForHash().entries(key);
        return map;
    }

    /**
     * 修改支付密码
     *
     * @param mobile
     * @return
     */
    @Override
    public Map<Object, Object> getRedis4PayPwd(String mobile) {
        return getRedis4Key(PREFIX_CONSUMER_SMS_PAY_PWD + "-" + mobile);
    }

    /**
     * 自刷
     *
     * @param mobile
     * @return
     */
    @Override
    public Map<Object, Object> getRedis4Cashout(String mobile) {
        return getRedis4Key(PREFIX_CONSUMER_SMS_CASHOUT + "-" + mobile);
    }

    /**
     * 添加银行卡
     *
     * @param mobile
     * @return
     */
    @Override
    public Map<Object, Object> getRedis4AddBankCard(String mobile) {
        return getRedis4Key(PREFIX_CONSUMER_SMS_BANK_CARD + "-" + mobile);
    }

    /**
     * 添加结算卡
     *
     * @param mobile
     * @return
     */
    @Override
    public Map<Object, Object> getRedis4AddDepositCard(String mobile) {
        return getRedis4Key(PREFIX_CONSUMER_SMS_DEPOSIT_CARD + "-" + mobile);
    }

    /**
     * 注册
     *
     * @param mobile
     * @return
     */
    @Override
    public Map<Object, Object> getRedis4signUp(String mobile) {
        return getRedis4Key(PREFIX_CONSUMER_SMS_SIGN_UP + "-" + mobile);
    }

    /**
     * 修改登录密码
     *
     * @param mobile
     * @return
     */
    @Override
    public Map<Object, Object> getRedis4LoginPwd(String mobile) {
        return getRedis4Key(PREFIX_CONSUMER_SMS_LOGIN_PWD + "-" + mobile);
    }
}
