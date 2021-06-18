package com.thread;

/**
 * 多线程
 * 谁有问题谁结束 并不会影响其他的线程
 * 遇多线程的问题就是用同步来解决，如果同步没有解决， 要考虑多个线程是同一个锁，锁住
 *
 *  线程间通信：多个线程在处理同一个资源，但是任务却不
 *  等待 唤醒机制
 *  1. wait():  让线程处于冻结状态，被wait的线程会被存储到线程池中
 *  2. notity(): 唤醒线程池中一个线程（任意）
 *  3。notifyAll();: 唤醒线程池中所有线程
 *
 *  这些方法 必须定义在锁中，因为这些方法是用于操作线程状态的方法，必须要明确到底操作的是哪个锁上的线程
 *
 *  wait(), notify(), notifyAll() 用来操作线程为什么定在了Object 类中？
 *    因为这些方法是监视器的方法，监视器其实就是锁。
 *    锁可以是任意对象，所以任意对象调用的方法一定定义Object类中
 *  wait() sleep（） 有什么区别？
 *       wait() 释放cpu 执行权，释放锁
 *       sleep（） 释放cpu执行权，不释放锁
 *
 *
 *
 */

class Resource{
    private String name;
    private String sex;
    private boolean flag = false;
    public synchronized void setInfo(String name, String sex){
        if(flag){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.name = name;
        this.sex = sex;
        this.flag = true;
        notify();

    }
    public synchronized void out(){
        if(!this.flag){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "...." + this.sex);
        this.flag = false;
        this.notify();

    }
}
//  输入
class Input implements Runnable{
    Resource resource;
    Input(Resource resource){
        this.resource = resource;
    }
    public void run() {
        int x = 0;
        while (true){
            if(x == 0) {
                 resource.setInfo("mike", "nan");
            } else {
                 resource.setInfo("丽丽", "女");
            }
            x = (x+1)%2;
        }
    }
}
// 输出
class Output implements Runnable{
    Resource resource;
    Output(Resource resource){
        this.resource = resource;
    }
    public void run() {
        while (true){
            resource.out();
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Demo demo1 = new Demo("网财富");
        Demo demo2 = new Demo("JK");
//        demo1.start();
//        demo2.start();
//        int d = 10/0; // 有错误
//        for (int i = 0; i < 20; i++) {
//            System.out.println(Thread.currentThread().getName());
//        }
//        ------------------------------- 进程间通信
        // 创建资源
        Resource resource = new Resource();
        // 创建任务
        Input input = new Input(resource);
        Output output = new Output(resource);
        // 创建线程
        Thread thread1 = new Thread(input);
        Thread thread2 = new Thread(output);
        // 开始线程
        thread1.start();
        thread2.start();



    }
}
