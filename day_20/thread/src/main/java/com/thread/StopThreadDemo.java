package com.thread;

/**
 * 怎么控制线程的任务结束呢？
 *      任务中都会有循环标记，只要控制住循环就可以结束任务
 *      控制循环通常就用定义标记来完成
 *
 * 但是如果线程处于了冻结状态，无法读取标记，如何结束呢？
 * 可以使用interrupt(中断) 方法,结束线程的冻结状态，使线程回到运行状态中来
 * 让线程具备cpu 的执行资格
 *
 * 但是强制动作会发生了InterrupExpection，记得要处理
 *
 */
class StopThread implements Runnable{
    private  boolean flag = true;

    @Override
    public synchronized void run() {
        while (flag){
            try {
                wait();

            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName() + "。。。。" + e);
                flag =false;
            }
            System.out.println(Thread.currentThread().getName() + "。。。。");
        }
    }
    public void setFlag(){
        flag = false;
    }
}

public class StopThreadDemo {
    public static void main(String[] args) {
        StopThread stopThread = new StopThread();

        Thread t1 = new Thread(stopThread);
        Thread t2 = new Thread(stopThread);

        t1.start();
        t2.start();
        int num = 1;
        for (;;){
            if(++num==50){
                t1.interrupt();
                t2.interrupt();
                break;
            }
            System.out.println("main..." + num);
        }
        System.out.println("over");


    }

}
