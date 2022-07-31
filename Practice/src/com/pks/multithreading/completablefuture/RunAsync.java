package com.pks.multithreading.completablefuture;

import java.util.concurrent.*;

/**
 *  Running asynchronous computation using runAsync()
 */
public class RunAsync {

    public void runAsync() throws ExecutionException, InterruptedException {
        // Run a task specified by a Runnable Object asynchronously.
        // CompletableFuture executes these tasks in a thread obtained from the global
        // ForkJoinPool.commonPool().
        // Can give thread pool also as part of executor below.
        // static CompletableFuture<Void>	runAsync(Runnable runnable, Executor executor)
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                // Simulate a long-running Job
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                System.out.println("I'll run in a separate thread than the main thread.");
            }
        });

        // Block and wait for the future to complete
        future.get();
    }

    public void runAsyncLambda() throws ExecutionException, InterruptedException {
        // Using Lambda Expression
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Simulate a long-running Job
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("I'll run in a separate thread than the main thread.");
        });
    }

    public void runAsyncLambdaWithExecutor() throws ExecutionException, InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);
        // pass executor threadPool as part of second param
        // Using Lambda Expression
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Simulate a long-running Job
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("I'll run in a separate thread than the main thread.");
        }, executor);
    }




}
