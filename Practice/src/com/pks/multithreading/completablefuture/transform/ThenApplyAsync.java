package com.pks.multithreading.completablefuture.transform;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThenApplyAsync {

    /**
     * All the callback methods provided by CompletableFuture have two async variants -
     *
     * // thenApply() variants
     * <U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn)
     * <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn)
     * <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn, Executor executor)
     * These async callback variations help you further parallelize your computations by executing the
     * callback tasks in a separate thread.
     *
     * Consider the following example -
     */
    public void thenApply(){
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Some Result";
        }).thenApply(result -> {
            /*
              Executed in the same thread where the supplyAsync() task is executed
              or in the main thread If the supplyAsync() task completes immediately
              (Remove sleep() call to verify)
            */
            return "Processed Result";
        });
    }

    /**
     * In the above case, the task inside thenApply() is executed in the same thread where the supplyAsync()
     * task is executed, or in the main thread if the supplyAsync() task completes immediately (try removing
     * sleep() call to verify).
     *
     * To have more control over the thread that executes the callback task, you can use async callbacks.
     * If you use thenApplyAsync() callback, then it will be executed in a different thread obtained from
     * ForkJoinPool.commonPool() -
     */
    public void thenApplyAsync(){
        CompletableFuture.supplyAsync(() -> {
            return "Some Result";
        }).thenApplyAsync(result -> {
            // Executed in a different thread from ForkJoinPool.commonPool()
            return "Processed Result";
        });
    }

    /**
     * Moreover, If you pass an Executor to the thenApplyAsync() callback then the task will be executed in a
     * thread obtained from the Executor’s thread pool.
     */
    public void thenApplyAsync2(){
        Executor executor = Executors.newFixedThreadPool(2);
        CompletableFuture.supplyAsync(() -> {
            return "Some Result";
        }).thenApplyAsync(result -> {
            // Executed in a different thread from ForkJoinPool.commonPool()
            return "Processed Result";
        }, executor);
    }

}
