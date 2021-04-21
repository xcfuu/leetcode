package com.oomthread.lockoom.lockTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SortTest {
    List<Phone> phones = Arrays.asList(new Phone(1, "苹果"),
            new Phone(2, "小米"),
            new Phone(3, "华为"),
            new Phone(4, "一加"),
            new Phone(5, "vivo"));
    JedisPoolConfig poolConfig = new JedisPoolConfig();
    JedisPool jedisPool = new JedisPool(poolConfig, "192.168.0.249", 6379, 3000,"Admin888.");
    final Jedis jedis = jedisPool.getResource();
    public void sortTest(){
        //jedis.zadd("fenshu",5,"e");
        //jedis.zadd("fenshu",3,"c");
        //jedis.zadd("fenshu",1,"a");
        //jedis.zadd("fenshu",2,"b");
        //jedis.zadd("fenshu",4,"d");
        jedis.zincrby("fenshu",2,"b");
        Long sum = jedis.zcard("fenshu");
        System.out.println("sum------"+sum);
        Set<String> set = jedis.zrange("fenshu", 0, -1);
        System.out.println("set--------"+set);
        Double fen = jedis.zscore("fenshu", "b");
        System.out.println("fen--------"+fen);
/*
        Set<String> set1 = jedis.zrange("fenshu", 0, -1);
        System.out.println("set1--------"+set1);*/

    }

    public static void main(String[] args) {
        SortTest sortTest =new SortTest();
        sortTest.sortTest();
    }
}
