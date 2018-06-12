package com.pks.multithreading.executer.mythreadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClass {

	public static void main(String[] args) throws InterruptedException {
		CompletionService threadService;
		ExecutorService service = Executors.newFixedThreadPool(2);
		threadService = new ExecutorCompletionService(service);

		long b = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			threadService.submit(new MyRunable(i));
		}

		service.shutdown();
		System.out.println("time taken by Completion Service "
				+ (System.currentTimeMillis() - b));

		DefaultResultListener result = new DefaultResultListener();
		MyThreadPool newPool = new MyThreadPool(2, result);
		long a = System.currentTimeMillis();

		int cc = 0;
		for (int i = 0; i < 50000; i++) {
			cc = cc + i;
		}
		System.out.println("time taken without any pool "
				+ (System.currentTimeMillis() - a));
		a = System.currentTimeMillis();

		for (int i = 0; i < 5000; i++) {
			newPool.submit(new MyRunable(i));
		}

		newPool.stop();
		System.out.println("time taken by myThreadPool "
				+ (System.currentTimeMillis() - a));
	}

}

class MyRunable implements Callable<Integer> {
	int index = -1;

	public MyRunable(int index) {
		this.index = index;
	}

	@Override
	public Integer call() throws Exception {
		return index;
	}

}
