package com.thread;

class  MyRunnabled4 implements Runnable{

    boolean run = true;

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
