package com.pks.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Allows one or more threads to wait until a set of operations being performed in other threads complete.
 *
 * CountDownLatch is a good for one-time events like application start-up time.
 * 
 * Below example requires 3 services namely CacheService, AlertService and ValidationService to be started and ready before 
 * application can handle any request.
 * 
 * Can not reuse CountDownLatch
 * 
 */
public class CountDownLatch_1 {

	public static void main(String[] args) {
		
		final CountDownLatch latch = new CountDownLatch(3);
		Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
		Thread alertService = new Thread(new Service("AlertService", 1000, latch));
		Thread validationService = new Thread(new Service("ValidationService", 1000, latch));

		cacheService.start(); // separate thread will initialize CacheService
		alertService.start(); // another thread for AlertService initialization
		validationService.start();

		// application should not start processing any thread until all service
		// is up
		// and ready to do there job.
		// Countdown latch is idle choice here, main thread will start with
		// count 3
		// and wait until count reaches zero. each thread once up and read will
		// do
		// a count down. this will ensure that main thread is not started
		// processing
		// until all services is up.

		// count is 3 since we have 3 Threads (Services)

	       try{
	            latch.await();  //main thread is waiting on CountDownLatch to finish
	            System.out.println("All services are up, Application is starting now");
	       }catch(InterruptedException ie){
	           ie.printStackTrace();
	       }

	}
	
	static class Service implements Runnable{
	    private final String name;
	    private final int timeToStart;
	    private final CountDownLatch latch;
	  
	    public Service(String name, int timeToStart, CountDownLatch latch){
	        this.name = name;
	        this.timeToStart = timeToStart;
	        this.latch = latch;
	    }
	  
	    @Override
	    public void run() {
	        try {
	            Thread.sleep(timeToStart);
	        } catch (InterruptedException ex) {
	            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        System.out.println( name + " is Up");
	        latch.countDown(); //reduce count of CountDownLatch by 1
	    }
	  
	}

}
