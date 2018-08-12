package com.pks.multithreading.executers;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.pks.multithreading.RunnableTask;

/**
  public static ExecutorService newFixedThreadPool(int nThreads) {
    return new ThreadPoolExecutor(
               nThreads, // once created a thread do not shrink the pool 
               nThreads,
               0L, TimeUnit.MILLISECONDS, // idle threads waits forever for new tasks
               new LinkedBlockingQueue<Runnable>());
}
 */

/**
 * 1 - nThreads, created initially // once created a thread do not shrink the pool 
 * 2 - idle threads waits forever for new tasks
 *
 */
public class MyFixedThreadExecutor {
	
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++)
        {
            RunnableTask task = new RunnableTask("Task " + i);
            System.out.println("A new task has been added : " + task.getName());
            executor.execute(task);
        }
        System.out.println("Maximum threads inside pool " + executor.getMaximumPoolSize());
        executor.shutdown();
	}

}
