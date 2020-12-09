package com.eliteams.quick4j.web.controller;

import redis.clients.jedis.Jedis;

public class RedisController {

    public static void main(String[] args) {
        //获取连接
        Jedis jedis = new Jedis("localhost",6379);
        jedis.auth("123456");
        //操作
        jedis.set("username","wzx1");

    }
}
