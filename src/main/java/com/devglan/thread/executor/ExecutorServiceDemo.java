package com.devglan.thread.executor;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorServiceDemo {

    @SneakyThrows
    public static void main(String[] args) {
       /* System.out.println(String.format("current thread - %s", Thread.currentThread().getName()));
        Thread t1 = new Thread(() ->
                System.out.println(String.format("Running in a separate thread - %s", Thread.currentThread().getName())));
        t1.start();*/
        //System.out.println(Runtime.getRuntime().availableProcessors());
        //ExecutorService executorService = Executors.newFixedThreadPool(4);
        //ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        //ExecutorService executorService2 = Executors.newCachedThreadPool();
        //ExecutorService executorService = Executors.newScheduledThreadPool(10);

        //executorService.execute(new RunnableDemo());
        //Future<String> result1 = executorService.submit(new CallableDemo());
        //result1.get();
        //Future result = executorService.submit(new RunnableDemo());
        //Future result3 = executorService.submit(new RunnableDemo());
        //ArrayList<Callable<String>> list = new ArrayList<>();
        //list.add(new CallableDemo());
        //list.add(new CallableDemo1());
        //List<Future<String>> results = executorService.invokeAll(list);
        /*results.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        List<Runnable> results3 = executorService.shutdownNow();
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
*/
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        //service.schedule(new CallableDemo(), 2, TimeUnit.SECONDS);
        //service.scheduleAtFixedRate(new RunnableDemo(), 1, 2, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new RunnableDemo(), 1, 2, TimeUnit.SECONDS);
    }
}
