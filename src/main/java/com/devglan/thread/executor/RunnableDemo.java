package com.devglan.thread.executor;

public class RunnableDemo implements Runnable {

    @lombok.SneakyThrows
    @Override
    public void run() {
        System.out.println("Inside run method of RunnableDemo");
        Thread.sleep(2000);
    }
}
