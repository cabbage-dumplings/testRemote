package com.test;

import java.util.concurrent.atomic.AtomicInteger;

public class First {
    static volatile int b = 0;
    public static void main(String[] args) throws Exception {
        test1();
    }
    public static void test1() throws Exception{
        AtomicInteger a = new AtomicInteger(0);
        Thread t1 = new Thread(() -> {
            try {
                System.out.println();
            } catch (Exception e) {
                //System.out.println("被打断");
                //System.out.println("被打断后"+Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        });
        /*Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10000; i++) {
                    //b++;
                    a.getAndIncrement();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });*/
        t1.start();
        System.out.println(t1.isInterrupted());
        t1.interrupt();
        for (int i = 0; i < 10000; i++) {
            a.getAndIncrement();
        }
        System.out.println("主线程"+t1.isInterrupted());
    }
}
