package com.learn.exam1;
// 面试题： doOther 方法执行的时候需要等待dosome 方法结束吗？不需要，因为doother 没有synchronized，没有获取锁
// 如果给 doOther 添加synchronized 需要等待吗 ？ 需要，因为需要锁了锁只有一把，需要等待

// 如果将doOther或doSome 添加staic 方法， 需需等待吗？ 需要？ 因为静态方法是类锁，不管创建了几个对象，类锁只有一把
public class Exam01 {
    public static void main(String[] args) {
        Myclass mc = new Myclass();

        Thread t1 = new MyThread(mc);
        Thread t2 = new MyThread(mc);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        t2.start();

    }
}
