package com.learn.Account;

/**
 * 数据安全是重点
 *
 * 2.1 发生条件？
 *  1 多线程并发
 *  2 共享数据
 *  3 共享数据有修改的行为
 *
 *2.2 怎么解决线程安全问题呢？
 *  当多线程并发的环境下，有共享数据，并且这个数据还会被修改，此时就会有线程安全问题
 *  1. 线程同步机制：  线程排队执行（不能并发）
 *
 * 2.3  编程模型
 *   1 异步编程模型 （并发）
 *   2 同步编程模型
 *
 * Java 中有三大变量？
 *
 * 实例变量： 在堆中
 * 静态变量： 在方法区中
 * 局部变量： 在栈中
 * 以上三大变量中：
 *   局部变量永远不会有存在线程安全问题。因为局部变零不会共享（一个线程一个栈）
 *
 *   静态实例在堆中，堆只有一个方法，
 *   静态变量在方法区中，方法区只有一个。
 *   堆和方法区都是多线程共享的，所以可能存在线程安全的问题。
 *
 *   局部变量+ 常量： 不会有线程安全问题
 *   成员变量： 可能会有线程安全问题
 *
 *4. 如果使用局部变量的话： 建议使用StringBuilder
 * 因为局部变量不存在安全问题，选择StringBuilder  StringBuilder效率比较低
 *
 * ArrayList  是非线程安全的
 * Vector 是线程安全的
 * HashMap HaseSet 是非线程安全的
 * Hashtable 是线程安全的
 *
 * 5 总结
 *
 * Synchronized 有三种写法：
 *   第一种： 同步代码块
 *   synchronized(线程共享对象){
 *       同步代码块
 *   }
 *
 *   第二种： 在实例的方法上使用synchronized
 *      表示共享对象一定是this
 *      并且同步代码块是整个方法体
 *
 *   第三种： 在静态方法上使用synchronized
 *   表示找类锁
 *   类所永远只有一把。对象锁 每个对象都有
 *
 * 6, 我们应该怎么解决线程安全问题
 *
 * 7 守护线程？
 * 分为：
 *   用户线程
 *   守护线程
 *     其中具有代表性的就是： 垃圾回收线程（守护线程）
 *
 *   特点： 一般守护线程就是一个死循环，所有的用户线程只要结束，守护线程自动结束
 *   注意： 主线程main方法是一个用户线程。
 *   在什么地方：
 *      每天零点的视乎系统自动备份。
 *      这个需要使用到定时器，并且我可以将定时器设置为守护进程。
 *      一直在那里看着，没到00.00 的时候就备份一次，所有的用户线程如果结束了，
 *      守护线程自动退出，没有必要进行数据备份了。
 *
 *
 *
 *
 *
 *
 */

public class AccountThread extends  Thread {
    // 俩个线程必须共享一个账户对象
    private Accounts accounts;

    public AccountThread(Accounts accounts){
        this.accounts =accounts;
    }
    public  void run(){
        double money = 5000;
        accounts.withdraw(money);
        System.out.println("账户"+accounts.getActno()+"取款成功,余额" + accounts.getBalance());

    }
}