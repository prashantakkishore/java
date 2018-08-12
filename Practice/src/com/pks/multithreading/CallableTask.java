package com.pks.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTask implements Callable<Long> {

	@Override
	public Long call() throws Exception {
		Long duration = (long) (Math.random() * 10);
		try {

			System.out.println("Running  Callable Task! ,sleeping for : " + duration + " seconds");
			TimeUnit.SECONDS.sleep(duration);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return duration;
	}

}
