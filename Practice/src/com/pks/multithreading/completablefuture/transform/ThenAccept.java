package com.pks.multithreading.completablefuture.transform;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * If you don’t want to return anything from your callback function and just want to run some
 * piece of code after the completion of the Future, then you can use thenAccept() and thenRun()
 * methods. These methods are consumers and are often used as the last callback in the callback chain.
 *
 * CompletableFuture.thenAccept() takes a Consumer<T> and returns CompletableFuture<Void>.
 * It has access to the result of the CompletableFuture on which it is attached.
 *
 * While thenAccept() has access to the result of the CompletableFuture on which it is attached,
 * thenRun() doesn’t even have access to the Future’s result. It takes a Runnable and returns
 * CompletableFuture<Void> -
 */
public class ThenAccept {

    public void thenAccept() throws ExecutionException, InterruptedException {
        // thenAccept() example
        CompletableFuture.supplyAsync(() -> {
            // return ProductService.getProductDetail(productId);
            return "product";
        }).thenAccept(product -> {
            System.out.println("Got product detail from remote service " + "product.getName()");
        });
    }
}
