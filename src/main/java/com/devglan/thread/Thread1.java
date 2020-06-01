package com.devglan.thread;

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
        synchronized (r1){
            System.out.println("Lock on R1 acquired by " + Thread.currentThread().getName());
            try {
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
