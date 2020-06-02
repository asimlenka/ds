package com.devglan.thread;

public class Wait {

    public synchronized void waitCheck(){
        System.out.println(Thread.currentThread().getName());
        try {
            wait();//releases the lock
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Wait wait = new Wait();
        new Thread(() -> wait.waitCheck()).start();
        new Thread(() -> wait.waitCheck()).start();
    }
}
