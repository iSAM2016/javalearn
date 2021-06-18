package com.thread.exam1;

public class Myclass {
    public  synchronized  void  doSome(){
        System.out.println("do some begin");
        try {
            Thread.sleep(1000*10);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("do some over");
    }
    public  void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther over");
    }
}
