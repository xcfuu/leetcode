package com.oomthread.lockoom.bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo1 {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo1 demo = new ThreadLocalDemo1();
        demo.run();


    }

    public void run() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Task());
        System.gc();
        System.out.println("运行30s后停止线程");
        Thread.currentThread().sleep(30000);
        executorService.shutdown();
        System.out.println("线程停止，运行GC查看");
        Thread.currentThread().sleep(30000);
        System.out.println("线程停止");

    };


    class Task implements Runnable{
        @Override
        public void run() {
            ThreadLocal<byte[]> localString = new ThreadLocal<>();
            localString.set(new byte[1024*1024*200]);
        }
    }

}
