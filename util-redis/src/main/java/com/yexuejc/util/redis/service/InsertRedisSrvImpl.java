package com.yexuejc.util.redis.service;

import com.yexuejc.util.base.util.JsonUtil;
import com.yexuejc.util.redis.autoconfigur.MutiRedisAutoConfiguration;
import com.yexuejc.util.redis.web.vo.InsertRedisVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 新增redis
 *
 * @PackageName: com.yexuejc.util.redis.service
 * @Description:
 * @author: maxf
 * @date: 2018/1/17 14:14
 */
@Service("insertRedisSrvImpl")
public class InsertRedisSrvImpl extends RedisDefSrvImpl implements RedisSrv {
    @Autowired
    @Qualifier(MutiRedisAutoConfiguration.BEAN_REDIS_TEMPLATE0)
    RedisTemplate<Object, Object> redisTemplate0;
    @Autowired
    @Qualifier(MutiRedisAutoConfiguration.BEAN_REDIS_TEMPLATE1)
    RedisTemplate<Object, Object> redisTemplate1;
    @Autowired
    @Qualifier(MutiRedisAutoConfiguration.BEAN_REDIS_TEMPLATE5)
    RedisTemplate<Object, Object> redisTemplate5;

    @Override
    public void insertConsumerSession(InsertRedisVO insertRedisVO) {
        switch (insertRedisVO.getDb()) {
            case 0:
                redisTemplate0.afterPropertiesSet();
                redisTemplate0.opsForHash().putAll(
                        insertRedisVO.getType() + "-" + insertRedisVO.getKey(),
                        JsonUtil.json2Obj(insertRedisVO.getValue(), Map.class));
                // 过期时间：不过期
//                redisTemplate0.expire(insertRedisVO.getType() + "-" + insertRedisVO.getKey(),
//                        5 * 60, TimeUnit.SECONDS);
                break;
            case 1:
                redisTemplate1.afterPropertiesSet();
                redisTemplate1.opsForHash().putAll(
                        insertRedisVO.getType() + "-" + insertRedisVO.getKey(),
                        JsonUtil.json2Obj(insertRedisVO.getValue(), Map.class));
                // 过期时间：5分钟
                redisTemplate1.expire(
                        insertRedisVO.getType() + "-" + insertRedisVO.getKey(),
                        5 * 60, TimeUnit.SECONDS);
                break;
            case 5:
                redisTemplate5.afterPropertiesSet();
                redisTemplate5.opsForList().leftPushAll(insertRedisVO.getType() + "-" + insertRedisVO.getKey(),
                        JsonUtil.json2Obj(insertRedisVO.getValue(), List.class));
                break;
            default:
                break;
        }
    }
}
