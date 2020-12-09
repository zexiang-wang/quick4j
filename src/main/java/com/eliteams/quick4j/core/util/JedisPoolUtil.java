package com.eliteams.quick4j.core.util;

import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author wyx
 * @date 2020/12/2
 * @Time 0:33
 */
public class JedisPoolUtil {

    @Value("${redis.host}")
    private static final String HOST = "127.0.0.1";

    @Value("${redis.port}")
    private static final int PORT = 6379 ;

    @Value("${redis.password}")
    private static final String PASSWORD = "123456";

    private static volatile JedisPool jedisPool = null;

    private static JedisPool getJedisPoolInstance(){
        if(jedisPool == null){
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            //最大连接数
            poolConfig.setMaxTotal(50);
            //最大空闲连接数
            poolConfig.setMaxIdle(30);
            poolConfig.setMinIdle(10);
            //最大等待时间
            poolConfig.setMaxWaitMillis(20 * 1000);
            //检查连接池的可用性，确保获取的redis实例可用
            //在borrow一个jedis实例时，是否提前进行validate操作：如果为ture，则得到的jedis实例均是可用的
            poolConfig.setTestOnBorrow(false);
//            poolConfig.setTestOnCreate(false);
            //poolConfig.setTestOnReturn(false);

            //无密码构造
//            jedisPool = new JedisPool(poolConfig,HOST,PORT);
            //有密码构造，需要设置密码，设置密码可以在获取到jedis对象后，jedis.auth("密码"),也可以在此时使用构造入参设置
            jedisPool = new JedisPool(poolConfig, HOST, PORT, 10 * 10000, PASSWORD);

        }
        return jedisPool;
    }
    public static Jedis getJedisInstance(){
        Jedis jedis = getJedisPoolInstance().getResource();
        return jedis;
    }

    public static void release(Jedis jedis){
        jedis.close();
    }

}
