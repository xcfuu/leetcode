package com.oomthread.lockoom.bean;

import org.springframework.stereotype.Component;

@Component
public class TestAllocation {
    private static final int _1MB = 1024* 1024;

    public void testAllocation(){
        byte[] allocation,allocation2,allocation3,allocation4;
        allocation = new byte[2*_1MB];
        allocation2 = new byte[4*_1MB];
        allocation3 = new byte[8*_1MB];
        allocation4 = new byte[16*_1MB];
        try {
            Thread.sleep(90000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
