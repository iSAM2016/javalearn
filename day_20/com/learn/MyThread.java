package com.learn;

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
