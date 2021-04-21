package com.learn;

/**
 *
 *   如何让已经在沉睡的线程启动？
 *   使用T.interrupt(); 这种中断睡眠的方式议依靠ljava 的异常处理机制
 *
 *   怎么合理的终止线程？
 *
 *
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

class  MyRunnabled2 implements Runnable{
    // run（） 当中的异常不能throws 只能try catch
    // 子类不能比父类跑出更多的异常
    @Override
    public void run() {
        System.out.println("开始睡眠");
        try {
            Thread.sleep(1000 * 60 * 60);

        }catch (InterruptedException e){

        }
        System.out.println("睡眠结束");
    }

}

class  MyRunnabled4 implements Runnable{

    boolean run = true;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(run){
                System.out.println(Thread.currentThread().getName() + "---->" + i);
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }else {
                return;
            }
        }
    }
}