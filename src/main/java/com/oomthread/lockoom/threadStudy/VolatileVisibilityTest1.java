package com.oomthread.lockoom.threadStudy;

import java.util.ArrayList;

public class VolatileVisibilityTest1 {
    private static  boolean ready;
    private static  int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while(!ready){
                Thread.yield();
                System.out.println(number);
            }
        }
    }
    private static class WriteThread extends Thread{
        @Override
        public void run() {
            number=42;
            ready=true;
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<200;i++){
            new WriteThread().start();
            new ReaderThread().start();

        }

    }
}
