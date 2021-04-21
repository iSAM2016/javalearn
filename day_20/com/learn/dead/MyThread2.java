package com.learn.dead;

public class MyThread2 extends  Thread {
    Object o1;
    Object o2;
    public MyThread2(Object o1, Object o2){
        this.o1 = o1;
        this.o2 = o2;
    }
    public  void run(){
        synchronized (o1){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }

            synchronized (o2){

            }
        }
    }
}
