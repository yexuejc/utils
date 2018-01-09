package com.yexuejc.util.simple.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;

public class JedisTest {

    @Test
    public void jedis() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("hello", "redis-jedis");

        System.out.println(jedis.get("hello"));
        System.out.println(jedis.dbSize());
    }

    @Test
    public void setTest() throws IOException {
        RedisClient redisClient = new RedisClient("127.0.0.1", 6379);
        redisClient.set("hello", "redis");
        System.out.println(redisClient.get("hello"));
    }

    @Test
    public void dbSize() throws IOException {
        RedisClient redisClient = new RedisClient("127.0.0.1", 6379);
        System.out.println(redisClient.dbsize());
    }
}

