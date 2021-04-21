package com.oomthread.lockoom.bean;

import org.springframework.stereotype.Component;

@Component
public class JavaVMStackOOM {


    private void dontStop() {
       /* while (true) {
        }*/
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public  void run() {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
