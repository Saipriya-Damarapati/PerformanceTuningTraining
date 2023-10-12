package com.citi.training.deadlock;

public class Thread1 extends Thread {
    private A a;
    private B b;

    public Thread1(A a, B b) {
        super();
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (a) {
            System.out.println(Thread.currentThread().getName()+" has acquired lock on a");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(b) {
                System.out.println(Thread.currentThread().getName()+" has acquired lock on b");
            }
        }
    }
}