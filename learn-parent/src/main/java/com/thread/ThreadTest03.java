package com.thread;

/**
 * MyRunnable 创建线程
 */
public class ThreadTest03 {
    public static void main(String[] args) {
        // 创建一个可运行的对象
        MyRunnable runnable = new MyRunnable();
        // 将可运行的对象封装成一个线程对象
        Thread thread = new Thread(runnable);
        // 启动线程
        thread.start();
        for (int i = 0; i <4 ; i++) {
            System.out.println("主线程-->" + i);

        }

    }
}

