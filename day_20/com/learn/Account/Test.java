package com.learn.Account;

public class Test {
    public static void main(String[] args) {
        // 创建账户
        Accounts accounts = new Accounts("act-001", 10000);
        // 创建两个线程
        Thread thread = new AccountThread(accounts);
        Thread thread1 = new AccountThread(accounts);

        // 当新产生一个账户，account 对象变化了，this发生了变化，所以锁就不在同步了，是异步
        Accounts account3 = new Accounts("act-001", 10000);
        Thread thread2 = new AccountThread(account3);

        thread.setName("t1");
        thread1.setName("t2");
        thread.start();
        thread1.start();
        thread2.start();

    }
}
