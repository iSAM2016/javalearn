package com.learn;

/**
 * 怎么获取当前线程对象
 * Thread.currentThread(); 静态方法 出现在哪里就是那个线程
 *
 * sleep方法：
 * 1 静态方法： Thread.sleep(1000)
 * 2 参数是毫秒
 * 3 作用：让"当前"的线程进入休眠，进入"阻塞状态"，放弃cpu 时间片，让其他线程使用。
 * 出现在那个线程，那个线程就会进入休眠
 *
 */
public class ThreadTest05 {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        // 创建线程
//        MyThread myThread2 = new MyThread();
//        // 设置线程的名字
//        myThread2.setName("t2");
//        String tName = myThread2.getName();
//        System.out.println(tName);
//        myThread2.start();

        // 创建线程
        MyThread myThread1 = new MyThread();
        // 设置线程的名字
        myThread1.setName("t1");
        String tName1 = myThread1.getName();
        System.out.println(tName1);
        myThread1.start();

        try {
            // 这段代码会让 myThread1 进入休眠状态吗 在执行的时候还是会执行 Thread.sleep(1000*5)
            // 这段代码的意思是： 让当前的线程进入休眠，也就是main 进入休眠
            // 出现在main 中，main 下次讷航睡眠
            myThread1.sleep(1000*5);

        }catch (Exception e){
            e.printStackTrace();
        }
        // 5 秒之后会在这里执行
        System.out.println("hello work");
    }
}

