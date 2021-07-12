package com.learn.first;
/**
 * Runnable 的使用方法
 */
public class MyRunnable  {
    public static void main(String[] args) {
        // 创建一个可运行的对象
        ThreadTest03 runnable = new ThreadTest03();
        // 将可运行的对象封装成一个线程对象
        Thread thread = new Thread(runnable);
        // 启动线程
        thread.start();
        for (int i = 0; i <4 ; i++) {
            System.out.println("主线程-->" + i);
        }
    }
}

class ThreadTest03 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <4 ; i++) {
            System.out.println("分支线程-->" + i);
        }
    }
}

