package com.learn.second.dead;

public class MyThread1 extends  Thread {
    Object o1;
    Object o2;
    public MyThread1(Object o1, Object o2){
        this.o1 = o1;
        this.o2 = o2;
    }
    public  void run(){
        synchronized (o2){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }

            synchronized (o1){

            }
        }
    }
}
