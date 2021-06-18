package com.thread.Synchronized;

import java.util.concurrent.TimeUnit;
/**
 * 锁的重入, 同一个线程，多次调用同步代码，锁定同一个锁对象，可重入
 * 当 synchronized 出现在方法中，锁定的就是this
 * [Synchronized与三种锁态](https://blog.csdn.net/u010723709/article/details/50341631)
 */
public class Test {
    synchronized  void m1(){// 锁this
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end");
    }
    synchronized  void m2(){// 锁this
        System.out.println("m2 start");
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("m2 end");
    }
    public static void main(String[] args) {
        /**
         * 锁的重入, 同一个线程，多次调用同步代码，锁定同一个锁对象，可重入
         * 当 synchronized 出现在方法中，锁定的就是this
         */
//        new Test().m1();

        // 创建账户
        Accounts accounts = new Accounts("act-001", 10000);
        // 创建两个线程
        Thread thread = new AccountThread(accounts);
        Thread thread1 = new AccountThread(accounts);

        // 当新产生一个账户，account 对象变化了，this发生了变化，所以锁就不在同步了，是异步
        Accounts account3 = new Accounts("act-002", 10000);
        Thread thread2 = new AccountThread(account3);

        thread.setName("t1");
        thread1.setName("t2");
        thread.start();
        thread1.start();

        thread2.start();
    }
}
