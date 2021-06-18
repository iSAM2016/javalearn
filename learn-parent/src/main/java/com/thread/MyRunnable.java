package com.thread;

class  MyRunnable implements Runnable{
    public void run() {
        for (int i = 0; i <4 ; i++) {
            System.out.println("分支线程-->" + i);

        }
    }
}
