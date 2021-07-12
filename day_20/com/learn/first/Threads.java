package com.learn.first;

/**
 * 多线程
 * 只需要继承就可以了 可以并发执行
 * 第一种： 编写一个类， 直接继承java.lang.Thread 重写run 方法
 *
 * 创建线程？ new
 * 启动线程？ 调用start方法
 *
 * 第二种：编写一个类， 实现java.lang.Runnable 接口，实现Run方法
 * 
 */
public class Threads {
    public static void main(String[] args) {
         // 这里是main 方法，这里的代码属于主线程，在主栈运行
         // 新建Hige分支线程
         MyThread myThread = new MyThread();
         // 启动线程
        // start() 方法的作用是 启动一个分支线程，在jvm 中开辟一个新的空间栈，立马结束
        // 启动成功的线程会自动调用run方法， 并且run 方法在分支栈的栈底部（压栈）
        // run 方法在分支栈的底部，main 方法主栈的栈底部，run 和main 是平级的
        myThread.start(); //两个for是同时执行的 在不同的栈道
         // 这里运行主线程
        for (int i = 0; i <4 ; i++) {
            System.out.println("主线程");
        }
    }
}
