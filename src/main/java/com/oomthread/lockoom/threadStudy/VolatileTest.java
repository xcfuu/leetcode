package com.oomthread.lockoom.threadStudy;

public class VolatileTest extends Thread{
    int a=0;
    volatile int b=0;

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            VolatileTest test= new VolatileTest();
            Thread T1=new Thread(new Runnable() {
                @Override
                public void run() {
                    test.a=1;
                    test.b=1;
                    System.out.println("第次完成T1工作!");
                }
            });

            Thread T2=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("完成T2工作！"+"test.a="+test.a+"  test.b="+test.b);
                }
            });

            T1.start();
            T2.start();
        }

    }


}
