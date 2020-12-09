package com.eliteams.quick4j.web.service.impl;/*
package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.util.JedisPoolUtil;
import com.eliteams.quick4j.web.service.OrderSerivce;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.concurrent.CyclicBarrier;

*/
/**
 * @author wyx
 * @date 2020/12/2
 * @Time 10:12
 *//*

public class OderServiceImpl implements OrderSerivce{
    private static CyclicBarrier cb = new CyclicBarrier(60);

    //订单生成类
    //将orderNumGenerator或者count任意一处加上static，getNumber()加上同步锁，依然是线程安全的，因为使用的是同一个
//    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
    public static void main(String[] args) {
//        Jedis jedis = JedisPoolUtil.getJedisInstance();
//        String username = jedis.get("username");
//        System.out.println(username);
//        jedis.close();
    }
    }
*/
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
public class OderServiceImpl {

    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
        try {
            String str = "";
            String str1 = "";
            fis = new FileInputStream("c:\\Users\\Administrator\\Desktop\\sql\\ZJ_BANK_VOUCHER_PUSH_LOG.sql.txt");// FileInputStream  C:\Users\Administrator\Desktop\sql
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
            while ((str = br.readLine()) != null) {
                str1 += str + "\n";
            }
            // 当读取的一行不为空时,把读到的str的值赋给str1
            System.out.println(str1);// 打印出str1
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}