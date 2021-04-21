package com.oomthread.lockoom.matespaseTest;

public class Test {
    public static int count = 0;
    public Test() {
        ++count;
        System.out.println(this.getClass().getClassLoader());
        System.out.println("count: " + count);
    }
}
