package com.pks.java.design_patterns.producer_consumer;

public class PCTestWaitNotify {

	public static void main(String[] args) throws InterruptedException {
		PC pc = new PC();
		Thread producerThread = new Thread(() -> {
			try {
				pc.produce();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Thread consumerThread = new Thread(() -> {
			try {
				pc.consume();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		producerThread.start();
		consumerThread.start();
		
//		producerThread.join();
//		consulerThread.join();
		
	}

}
