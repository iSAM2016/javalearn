package com.thread;

class  MyRunnabled2 implements Runnable{
    // run（） 当中的异常不能throws 只能try catch
    // 子类不能比父类跑出更多的异常
    public void run() {
        System.out.println("开始睡眠");
        try {
            Thread.sleep(1000 * 60 * 60);

        }catch (InterruptedException e){

        }
        System.out.println("睡眠结束");
    }

}
