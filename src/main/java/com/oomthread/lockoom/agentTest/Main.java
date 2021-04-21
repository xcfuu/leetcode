package com.oomthread.lockoom.agentTest;

import java.lang.management.ManagementFactory;

public class Main {

    public static void main( String[] args ) throws InterruptedException {
        /*Main demo = new Main();
        while (true) {
            demo.sayHello();
            demo.sayBye();
            System.out.println("-------------------");
            Thread.sleep(1000);
        }*/

        //System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        System.out.println(System.currentTimeMillis());
    }

    public void sayHello() {
        System.out.println("Hello World!");
    }

    public void sayBye() {
        System.out.println("Bye Bye");
        //System.out.println("fix good Bye!!");
    }

}
