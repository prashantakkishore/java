package com.pks.multithreading;

import java.util.concurrent.TimeUnit;

public class RunnableTask implements Runnable {
	
	private String name;
	 
	public RunnableTask()
    {
    }
	
    public RunnableTask(String name)
    {
        this.name = name;
    } 
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			Long duration = (long) (Math.random() * 10);
			System.out.println("Running Task! " + name + ",sleeping for : " +  duration + " seconds");
			TimeUnit.SECONDS.sleep(duration);
			System.out.println("Finished Task! " + name );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
