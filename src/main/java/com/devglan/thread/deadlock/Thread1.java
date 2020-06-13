package com.devglan.thread.deadlock;

public class Thread1 implements Runnable{

    Object r1;
    Object r2;

    public Thread1(Object r1, Object r2){
        this.r1 = r1;
        this.r2 = r2;
    }
    @Override
    public void run() {
        //nested synchronised block
        //a thread acquires lock on object r1 and then acquires the lock on object r2. At the same time another thread acquires lock on object r2 first
        //and then tries to acquire lock on object r1 then the dead lock will happen as each thread is waiting for another to release the lock
        synchronized (r1){
            System.out.println("Lock on R1 acquired by " + Thread.currentThread().getName());
            try {
                //acquire the lock for 2 sec just for demo. By this time another thread (implementation in Thread2) will acquire lock on r2
                //and both are waiting for each other to release the lock.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (r2){
                System.out.println("Lock on R2 acquired by " + Thread.currentThread().getName());
            }
        }
    }
}
