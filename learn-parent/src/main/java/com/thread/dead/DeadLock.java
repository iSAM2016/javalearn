package com.thread.dead;


/**
 * 死锁 怎么书写
 */

public class DeadLock {
    public static void main(String[] args) {
         Object o1 = new Object();
         Object o2 = new Object();
         // t1 t2 两个线程桐乡 o1 o2
         Thread thread1 = new MyThread1(o1, o2);
         Thread thread2 = new MyThread2(o1, o2);
         thread1.start();
         thread2.start();

    }
}
