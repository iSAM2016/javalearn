package com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized  同步代码块，对于锁的操作是隐式的
 * jdk 1.5 以后将同步和锁封装成了对象，并将操作锁的隐式方式定义到了该对象中，将隐式动作变成了显示动作
 *
 * 接口Lock: 出现代替了同步代码块或者同步函数，将同步的隐式锁操作变成现实操作。
 *  同时更为灵活，可以一个锁上加上更多组监视器
 *  lock(): 获取锁
 *  unlock(): 释放锁，通常需要定义finally 代码块中
 *
 *  Condition 接口： 出现代替了Object中的wait notify notifyAll 方法
 *              将这些监视器方法单独进行了封装，变成Condition 监视器对象
 *              可以任意进行组合
 *
 *  await();
 *  signal();
 *  signalAll();
 *
 *  wait 和sleep 的区别？
 *
 *   1. wait 可以指定事假也可以不指定 sleep 必须指定时间
 *   2。 在同步时候，对CPU 的执行权和锁的处理不同
 *          wait: 释放执行权 释放锁
 *          sleep: 释放执行权 不释放锁
 *
 * 可以使用自定义锁
 *
 *  之前的痛苦在于 一个锁上只能有一组监视器，即监视生产者，也监视着消费者，意味着 这组监视器既能将生产者和消费者wait 也能 notity, 而线程能分类
 *   一组监视生产
 *   一组监视消费
 */
class  Resrouces {
    private  String name;
    private  int count = 1;
    private  boolean flag =false;
    // 创建一个锁对象
    Lock lock = new ReentrantLock();
    // 通过已有的锁获取该锁上的监视器对象
//    Condition condition = lock.newCondition();
     // 通过已有的锁获取两组监视器 一组 监视生产者 一组监视消费者
    Condition producer_condition = lock.newCondition();
    Condition consumer_condition = lock.newCondition();

    public  void set(String name){
        lock.lock();
        try {
            while (flag){
                try {
//                    condition.await();
                    producer_condition.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            this.name = name + count;
            count++;
            System.out.println(Thread.currentThread().getName() +"..生产者.." + count);
            flag = true;
            consumer_condition.signal();
        }finally {
            lock.unlock();
        }

    }
    public  synchronized void out(){
        lock.lock();
        try {
            while(!flag){
                try {
//                    condition.await();
                    consumer_condition.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() +"..消费者....." + count);
            flag = false;
            producer_condition.signal();
        }finally {
            lock.unlock();
        }

    }

}

class Producers implements  Runnable{
    private Resrouces resource;
    Producers(Resrouces resource){
        this.resource = resource;
    }
    public void run(){
        while (true){
            resource.set("烤鸭");
        }
    }
}

class Consumers implements  Runnable{
    private Resrouces resource;
    Consumers(Resrouces resource){
        this.resource = resource;
    }
    public void run(){
        while (true){
            resource.out();
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Resrouces resrouces = new Resrouces();
        Producers producers = new Producers(resrouces);
        Consumers consumers = new Consumers(resrouces);

        Thread thread0 = new Thread(producers);
        Thread thread1 = new Thread(producers);
        Thread thread2 = new Thread(consumers);
        Thread thread3 = new Thread(consumers);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
