package com.devglan.thread.cyclicbarrier;

//5 process to be run. 2 process to be run in parallel and after completion of 2 these processes the other 2 processes should run in parallel
//and then the last process should run
//can be achieved with ExecutorService but do the raw implementation
public class ConcurrencyDemo {

    public void process1(){
        System.out.println("Process 1 has started...");
        try {
            Thread.sleep(3000);
            System.out.println("Process 1 has completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void process2(){
        System.out.println("Process 2 has started...");
        try {
            Thread.sleep(2000);
            System.out.println("Process 2 has completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void process3(){
        System.out.println("Process 3 has started...");
        try {
            Thread.sleep(2000);
            System.out.println("Process 3 has completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void process4(){
        System.out.println("Process 4 has started...");
        try {
            Thread.sleep(2000);
            System.out.println("Process 4 has completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void process5(){
        System.out.println("Process 5 has started...");
        try {
            Thread.sleep(1000);
            System.out.println("Process 5 has completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ConcurrencyDemo concurrencyDemo = new ConcurrencyDemo();
        Thread t1 = new Thread(() -> concurrencyDemo.process1());
        Thread t2 = new Thread(() -> concurrencyDemo.process2());
        t1.start();
        t2.start();
        System.out.println("waiting for process 1 and process 2 to complete");
        //stop current running thread(main thread) and resume after t1 and t2 completes
        t1.join();
        t2.join();
        System.out.println("completed processing of process 1 and 2");
        t1 = new Thread(() -> concurrencyDemo.process3());
        t2 = new Thread(() -> concurrencyDemo.process4());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        t1 = new Thread(() -> concurrencyDemo.process5());
        t1.start();
    }
}


/*waiting for process 1 and process 2 to complete
        completed processing of process 1 and 2
        Process 2 has started...
        Process 1 has started...
        59
        Process 3 has started...
        Process 4 has started...
        Process 5 has started...
        Process 5 has completed
        Process 2 has completed
        Process 3 has completed
        Process 4 has completed
        Process 1 has completed*/
