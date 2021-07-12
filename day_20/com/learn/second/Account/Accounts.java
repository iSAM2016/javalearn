package com.learn.second.Account;

public class Accounts {
    // 账号
    private  String actno;
    // 余额
    private double balance;

    public Accounts(){

    }

    public Accounts(String actno, double balance){
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno(){
        return  actno;
    }
    public  void  setActno(String actno){
        this.actno = actno;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    // 取款的方法
    public  void  withdraw(double money){
        /**
         * 线程同步机制语法是
         * synchronized(谁的共享对象){
         *     // 线程同步代码块
         *     这个数据必须是多线程共享的数据，才能达到多线程排队
         * }
         *
         * （） 中写什么？
         *
         *   那需要看你让那些线程同步。
         *   假如t1 t2 t3 需要排队，t4 t5 不需要排队？
         *   你一定要在（）中写一个 t1 t2 t3 共享的对象，而这个对象对于t3 t4 不是共享的。
         *
         *  这里是账户是共享对象，可能是this 可能是其他共享对象
         *
         *  synchronized 执行原理？
         *  1. 架设t1 和 t2 线程并发。开始执行以下代码的时候，肯定有一个先。一个后，
         *  2 架设t1 先执行了，遇到了synchronized 这个时候自动找，"后面共享对象"的对象锁， 找到之后并占有这把锁。
         *   然后，然后执行同步代码块中的程序，在程序执行过程中一直都是占有这把锁，知道同步代码块结束，才会把这个锁释放。
         *  3 架设t1 已经占有这把锁，t2 也遇到了synchronized ，关键字，也会企业占有后面共享对象的这把锁。结果这把锁被t1 占有。t2 只能在
         *  在同步代码块执行结束了，t1 会归还这把锁，此时t2 终于等到这把锁执行结束，才能进入代码块
         *
         *  需要注意的是，这共享对象一定要选好了，这个共享对象一定是需要排队执行的这些线程对象锁共享的
         *
         *  类锁永远只有一把锁，对像锁有n 个，每个对象一个
         *
         *  当synchronized 方法出现在方法中可以吗？
         *      synchronized  出现在实例方法上，一定锁的是this,没得挑， 只能是this，不能是其他对象。所以这种方式不灵活。
         *
         *      另外还有一个缺点： synchronized 出现在实例方法上，表示整个方法都是需要同步的，可能Juin无故扩大同步的范围，导致程序的
         *      执行效率底下。
         *
         *      优点： 代码少
         *
         *
         */
        synchronized(this){
            // 取款之前的金额
            double before  = this.getBalance();
            // 取款之后的价格
            double after = before - money;
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            // 更新余额
            this.setBalance(after);
        }
    }
}