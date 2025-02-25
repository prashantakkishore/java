package com.pks.multithreading.executers;

/**
 * 1 - One one thread will be running tasks
 * 2 - Used to run Tasks in sequncial manner that it was submitted
 *
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.pks.multithreading.RunnableTask;

public class MySingleThreadExecutor {

	public static void main(String[] args) {
		ExecutorService singleThreadExecuter = Executors.newSingleThreadExecutor();

		try {

			singleThreadExecuter.submit(new RunnableTask());
			System.out.println("Shutdown executor");
			singleThreadExecuter.shutdown();
			// Wait for Task to finish in 5 seconds
			singleThreadExecuter.awaitTermination(5, TimeUnit.SECONDS);
			
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted");
		} finally {

			if (!singleThreadExecuter.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			singleThreadExecuter.shutdownNow();
			System.out.println("shutdown finished");
		}
	}

}
