package com.oomthread.lockoom.bean;

import org.springframework.stereotype.Component;

@Component
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public void run(){
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length" + oom.stackLength);
            throw e;
        }
    }

}
