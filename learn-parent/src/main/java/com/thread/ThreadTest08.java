package com.thread;

/**
 *
 * 如何让已经在沉睡的线程启动？
 *   使用T.interrupt(); 这种中断睡眠的方式议依靠ljava 的异常处理机制
 *
 * 怎么合理的终止线程？
 *
 *
 */
public class ThreadTest08 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnabled2());
        thread.setName("t");
        thread.start();
        System.out.println("主线程开始");
        try {
            Thread.sleep(1000*2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // 中断t 线程的睡眠（这种方式是依靠了java 的异常处理机制）
        thread.interrupt();

        // 终止线程
        MyRunnabled4 runnabled4 = new MyRunnabled4();
        Thread thread1 = new Thread(runnabled4);
        thread1.setName("t");
        thread1.start();

        try {
            Thread.sleep(1000*5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // 终止线程
        runnabled4.run = false;
    }
}



