package com.devglan.thread;

import java.util.Stack;

public class ProducerConsumer {
    private Stack<String> list = new Stack<>();

    public synchronized void produce() {
        if (list.size() > 10){
            try {
                System.out.println("Waiting for consumers to empty stack");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add("a");
        notifyAll();
    }

    public synchronized void consume() {
        if (list.size() == 0){
            try {
                System.out.println("Waiting for producers to produce");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(list.pop());
        notifyAll();
    }

    public static void main(String[] args) throws Exception{
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread t1 = new Thread(producerConsumer::produce);
        Thread t2 = new Thread(producerConsumer::consume);

        t2.start();
        Thread.sleep(2000);
        t1.start();
    }


}

