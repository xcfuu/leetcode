package com.oomthread.lockoom.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        HashMap<PhoneNumber, String> map = new HashMap<>();
        PhoneNumber p1=new PhoneNumber(027, 12345678);
        map.put(p1, "zhangsan");
        p1.setPhoneNumber(12345);
        map.put(p1, "lisi");
        map.put(new PhoneNumber(027, 22222222), "wangwu");
        map.put(new PhoneNumber(027, 33333333), "abc");

        System.out.println(map.toString());

        System.out.println(map.get(new PhoneNumber(027, 12345678)));
        System.out.println(map.get(new PhoneNumber(027, 12345)));
        System.out.println(map.get(new PhoneNumber(027, 22222222)));
        System.out.println(map.get(new PhoneNumber(027, 33333333)));



    }

    /*public static void main(String[] args) {
        PhoneNumber p1=new PhoneNumber(027, 12345678);
        PhoneNumber p2=new PhoneNumber(027, 22222222);
        PhoneNumber p3=new PhoneNumber(027, 33333333);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());


    }*/


}
