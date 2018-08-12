package com.pks.multithreading;

import java.util.concurrent.Semaphore;
/**
 * Allows to impose a bound on resource
 * Useful to implement 'producer consumer' design pattern or implement bounded pool or resources like 'Thread Pool', 'DB Connection pool'
 * 
 **/ 

public class Semaphore_1 {
	Semaphore binary = new Semaphore(1);
	  
    public static void main(String args[]) {
    	
        final Semaphore_1 test = new Semaphore_1();
        
        new Thread(){
            @Override
            public void run(){
              test.mutualExclusion(); 
            }
        }.start();
      
        new Thread(){
            @Override
            public void run(){
              test.mutualExclusion(); 
            }
        }.start();
      
    }
  
    private void mutualExclusion() {
        try {
            binary.acquire();

            //mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
            Thread.sleep(1000);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            binary.release();
            System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
        }
    } 
}
