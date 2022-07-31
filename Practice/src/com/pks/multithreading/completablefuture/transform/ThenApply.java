package com.pks.multithreading.completablefuture.transform;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * You can use thenApply() method to process and transform the result of a CompletableFuture
 * when it arrives. It takes a Function<T,R> as an argument. Function<T,R> is a simple functional
 * interface representing a function that accepts an argument of type T and produces a result of
 * type R -
 */
public class ThenApply {

    public void thenApply() throws ExecutionException, InterruptedException {
        // Create a CompletableFuture
        CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Rajeev";
        });

        // Attach a callback to the Future using thenApply()
        CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
            return "Hello " + name;
        });

        // Block and get the result of the future.
        System.out.println(greetingFuture.get()); // Hello Rajeev
    }

    public void multipleThenApply() throws ExecutionException, InterruptedException {

        CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Rajeev";
        }).thenApply(name -> {
            return "Hello " + name;
        }).thenApply(greeting -> {
            return greeting + ", Welcome to the CalliCoder Blog";
        });

        System.out.println(welcomeText.get());
        // Prints - Hello Rajeev, Welcome to the CalliCoder Blog

    }
}
