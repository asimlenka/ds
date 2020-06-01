package com.devglan.thread;

public class DeadlockRunner {

    public static void main(String[] args) {
        //two threads and two resources
        //acquires lock in the opposite order -> both thread t1 and t2 started and acquired lock on R1 and R2
        // and tries to acquire lock on R2 and R1 respectivly
        Object r1 = new Object();
        Object r2 = new Object();
        Thread1 thread1 = new Thread1(r1, r2);
        Thread2 thread2 = new Thread2(r1, r2);
         new Thread(thread1).start();
         new Thread(thread2).start();
    }
}
