package com.devglan.thread.deadlock;

public class Thread2 implements Runnable{

    Object r1;
    Object r2;

    public Thread2(Object r1, Object r2){
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void run() {
        //nested synchronised block
        synchronized (r2){
            System.out.println("Lock on R2 acquired by " + Thread.currentThread().getName());
            try {
                //acquire the lock for 2 sec just for demo. By this time another thread (implementation in Thread1) will acquire lock on r1
                //and both are waiting for each other to release the lock.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (r1){
                System.out.println("Lock on R1 acquired by " + Thread.currentThread().getName());
            }
        }

    }
}
