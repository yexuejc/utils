package com.yexuejc.util.redis.service;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.yexuejc.util.redis
 * @Description:
 * @author: maxf
 * @date: 2018/1/8 11:38
 */
public interface RedisSrv {
    List<Map<Object, Object>> getRedisAll();

    /**
     * 根据key 获取redis value(Map)
     *
     * @param key
     * @return
     */
    Map<Object, Object> getRedis4Key(String key);

    /**
     * 修改支付密码
     *
     * @param mobile
     * @return
     */
    Map<Object, Object> getRedis4PayPwd(String mobile);

    /**
     * 添加银行卡
     *
     * @param mobile
     * @return
     */
    Map<Object, Object> getRedis4AddBankCard(String mobile);

    /**
     * 添加结算卡
     *
     * @param mobile
     * @return
     */
    Map<Object, Object> getRedis4AddDepositCard(String mobile);

    /**
     * 自刷
     *
     * @param mobile
     * @return
     */
    Map<Object, Object> getRedis4Cashout(String mobile);

    /**
     * 注册
     *
     * @param mobile
     * @return
     */
    Map<Object, Object> getRedis4signUp(String mobile);

    /**
     * 修改登录密码
     *
     * @param mobile
     * @return
     */
    Map<Object, Object> getRedis4LoginPwd(String mobile);

    Map<Object, Object> getRedis4Consumer(String mobile);

    Map<Object, Object> getRedis4Admin(String mobile);
}
