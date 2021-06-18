package com.thread;

/**
 * 创建多线程
 *  * 自定义线程继承Thread 类
 *  * 重写run() 方法 编写线程执行体
 *  * 创建线程对象，调用start() 方法启动线程
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        // 编写程序，这段程序在分支线程中（分支栈）
    Thread currentThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThread.getName() + "分支线程--->" + i);
        }
    }
}
