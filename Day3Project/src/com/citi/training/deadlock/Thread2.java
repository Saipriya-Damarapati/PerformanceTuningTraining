package com.citi.training.deadlock;

public class Thread2 extends Thread {
    private A a;
    private B b;

    public Thread2(A a, B b) {
        super();
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (b) {
            System.out.println(Thread.currentThread().getName()+" has acquired lock on b");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(a) {
                System.out.println(Thread.currentThread().getName()+" has acquired lock on a");
            }
        }
    }
    
}