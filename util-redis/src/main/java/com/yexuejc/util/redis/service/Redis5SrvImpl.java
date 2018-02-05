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
@Service(value = "redis5SrvImpl")
public class Redis5SrvImpl extends RedisDefSrvImpl {

    @Autowired
    @Qualifier(MutiRedisAutoConfiguration.BEAN_REDIS_TEMPLATE5)
    RedisTemplate<Object, Object> redisTemplate5;

    @Override
    public List<Map<Object, Object>> getRedisAll() {
        List<Map<Object, Object>> list = new ArrayList<>();
        redisTemplate5.afterPropertiesSet();
        Set<Object> result = redisTemplate5.keys("*");
        for (Object object : result) {
            if (object instanceof String) {
                Map<Object, Object> pmap = new HashMap<>();
                List<Object> item = redisTemplate5.opsForList().range(String.valueOf(object), 0, 1000);
                pmap.put(object, item);
                list.add(pmap);
            }
        }
        return list;
    }

    @Override
    public String getGift(String key) {
        String giftId = (String) redisTemplate5.opsForList().leftPop(RedisConst.PREFIX_GIFT_SESSION + "-" + key);
        return giftId;
    }
}
