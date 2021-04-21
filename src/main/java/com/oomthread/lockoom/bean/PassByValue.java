package com.oomthread.lockoom.bean;

import java.util.HashSet;
import java.util.Set;

public class PassByValue {
//    public static void main(String[] args) {
//        int value = 1;
//
//        System.out.println(value);//执行changeValue方法前value的值为1
//        changeValue(value);
//        System.out.println(value);//执行changeValue方法后value的值仍旧为1
//    }

    // 值传递
    static void changeValue(int value) {
        value++;
    }

    public static void main(String[] args) {
        Set<String> set1=new HashSet<>();
        Set<String> set2=new HashSet<>();
        set1.add("a");
        set1.add("d");
        set2.add("a");
        set2.add("c");

        set1.addAll(set2);
        System.out.println(set1);

    }

}
