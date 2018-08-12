package com.pks.multithreading.executers;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.pks.multithreading.RunnableTask;

/**
 public static ExecutorService newCachedThreadPool() {
    return new ThreadPoolExecutor(0, // try to reduce the pool size to 0 if threads are idle long enough
                            Integer.MAX_VALUE, // almost no limit for the number of new threads started
                            60L, TimeUnit.SECONDS, // terminate thread after 60s idle
                            new SynchronousQueue<Runnable>());
}
 */
/**
 * 1 - Starts with 0 threads and creates if needed
 * 2 - terminate thread after 60s idle/running
 * 3 - Used for short lived tasks
 */

public class MyCachedThreadExecutor {

	
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
            RunnableTask task = new RunnableTask("Task ");
            System.out.println("A new task has been added : " + task.getName());
            executor.execute(task);
        
        System.out.println("Maximum threads inside pool " + executor.getMaximumPoolSize());
        executor.shutdown();
		
	}
}
