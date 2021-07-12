package com.thread;

/**
 * 生产者 消费者
 * 多生产 多消费为啥会有问题
 *   1.if判断只有一次，只要问题是 this.wait();  执行了以后 就停止运行，之后再次运行的时候也是从这里开始。没有判断flag,
 *   我们使用while 这样就每次判断了flag
 *   2.  使用 notify() 只是随机启动一个线程，这样就导致了不能让对方的线程启动，所以我们使用notifyAll()
 *   但是notifyAll 效率是地下的，因为他没有精确的唤醒对方，而是唤醒了所有
 */

class  MyResrouce {
    private  String name;
    private  int count = 1;
    private  boolean flag =false;
    public synchronized void set(String name){
        while (flag){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        this.name = name + count;
        count++;
        System.out.println(Thread.currentThread().getName() +"..生产者.." + count);
        flag = true;
        notifyAll();
    }
    public  synchronized void out(){
        while(!flag){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() +"..消费者....." + count);
        flag = false;
        notifyAll();
    }
}

class Producer implements  Runnable{
    private MyResrouce resource;
    Producer(MyResrouce resource){
        this.resource = resource;
    }
    public void run(){
        while (true){
            resource.set("烤鸭");
        }
    }
}

class Consumer implements  Runnable{
    private MyResrouce resource;
    Consumer(MyResrouce resource){
        this.resource = resource;
    }
    public void run(){
        while (true){
            resource.out();
        }
    }
}

public class ProduerConsumrDemo {
    public static void main(String[] args) {
       MyResrouce resrouce = new MyResrouce();
       Producer producer = new Producer(resrouce);
       Consumer consumer = new Consumer(resrouce);

       Thread thread0 = new Thread(producer);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        Thread thread3 = new Thread(consumer);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();


    }

}
