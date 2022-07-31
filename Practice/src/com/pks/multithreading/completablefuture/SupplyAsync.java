package com.pks.multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Run a task asynchronously and return the result using supplyAsync() -
 */
public class SupplyAsync {

    public void supplyAsync() throws ExecutionException, InterruptedException {

        // Run a task specified by a Supplier object asynchronously
        // CompletableFuture executes these tasks in a thread obtained from the global
        // ForkJoinPool.commonPool().
        // Can give thread pool also as part of executer below.
        // static <U> CompletableFuture<U>	supplyAsync(Supplier<U> supplier, Executor executor)
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                return "Result of the asynchronous computation";
            }
        });

        // Block and get the result of the Future
        String result = future.get();
        System.out.println(result);

    }

    public void supplyAsyncLambda() throws ExecutionException, InterruptedException {
        // Using Lambda Expression
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation";
        });
    }
}
