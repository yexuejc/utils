package com.yexuejc.util.redis.service;

import com.yexuejc.util.redis.autoconfigur.MutiRedisAutoConfiguration;
import com.yexuejc.util.redis.constant.RedisConst;
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
@Service(value = "redis0SrvImpl")
public class Redis0SrvImpl extends RedisDefSrvImpl {



    @Autowired
    @Qualifier(MutiRedisAutoConfiguration.BEAN_REDIS_TEMPLATE0)
    RedisTemplate<Object, Object> redisTemplate0;


    @Override
    public List<Map<Object, Object>> getRedisAll() {
        List<Map<Object, Object>> list = new ArrayList<>();
        redisTemplate0.afterPropertiesSet();
        Set<Object> result = redisTemplate0.keys("*");
        for (Object object : result) {
            if (object instanceof String) {
                Map<Object, Object> pmap = new HashMap<>();
                Map<Object, Object> item = redisTemplate0.opsForHash().entries(object);
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
        redisTemplate0.afterPropertiesSet();
        Map<Object, Object> map = redisTemplate0.opsForHash().entries(key);
        return map;
    }

    /**
     * 用户
     *
     * @param mobile
     * @return
     */
    @Override
    public Map<Object, Object> getRedis4Consumer(String mobile) {
        return getRedis4Key(RedisConst.PREFIX_CONSUMER_SESSION + "-" + mobile);
    }

    /**
     * 后台
     *
     * @param mobile
     * @return
     */
    @Override
    public Map<Object, Object> getRedis4Admin(String mobile) {
        return getRedis4Key(RedisConst.PREFIX_ADMIN_SESSION + "-" + mobile);
    }

}
