package com.thread.exam1;

import java.util.Map;

public class MyThread extends Thread {
    private Myclass mc;
    public  MyThread(Myclass mc){
        this.mc = mc;
    }
    public void run(){
        if(Thread.currentThread().getName().equals("t1")){
            mc.doSome();
        }
        if(Thread.currentThread().getName().equals("t2")){
            mc.doOther();
        }

    }
}
