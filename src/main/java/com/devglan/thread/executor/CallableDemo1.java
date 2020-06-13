package com.devglan.thread.executor;

import java.util.concurrent.Callable;

public class CallableDemo1 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Inside run method of CallableDemo1");
        //Thread.sleep(2000);
        return "done1";
    }
}
