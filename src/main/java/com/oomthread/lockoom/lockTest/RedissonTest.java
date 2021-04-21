package com.oomthread.lockoom.lockTest;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RedissonTest {
    /*    public static void main(String[] args) {

            Config config = new Config();
            config.useSingleServer().setAddress("redis://127.0.0.1:6379");
            config.useSingleServer().setPassword("redis1234");

            final RedissonClient client = Redisson.create(config);
            RLock lock = client.getLock("lock1");

            try{
                lock.lock();
            }finally{
                lock.unlock();
            }
        }*/

    static int inventory=10;
    public static void main(String[] args) {

        int NUM =100;
        LinkedBlockingQueue linkedBlockingQueue =new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory, inventory, 10L, SECONDS, linkedBlockingQueue);
        long start =System.currentTimeMillis();
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.0.249:6379");
        config.useSingleServer().setPassword("Admin888.");

        final RedissonClient client = Redisson.create(config);
        RLock lock = client.getLock("lock1");
        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    inventory--;
                    System.out.println("inventory=================="+inventory);
                    lock.unlock();
                }
            });
        }
        long end =System.currentTimeMillis();
        System.out.println("执行线程数:" + NUM + "   总耗时:" + (end - start) + "  库存数为:" + inventory);
    }


}
