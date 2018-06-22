package com.pks.java.design_patterns.producer_consumer;

import java.util.LinkedList;

public class PC {

	LinkedList<Integer> queue = new LinkedList<Integer>();

	int capacity = 1;

	public void produce() throws InterruptedException {
		while (true) {
			synchronized (queue) {
				if (queue.size() == capacity)
					try {
						queue.wait();
						System.out.println("Producer waiting ... ");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				else {
					queue.add(queue.size());
					queue.notifyAll();
					System.out.println("Produced : " + queue.size());

				}
				Thread.sleep(1000);
			}
		}

	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (queue) {
				if (queue.size() == 0)
					try {
						queue.wait();
						System.out.println("Consumer waiting ... ");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				else {
					Integer gotInt = queue.removeLast();
					queue.notifyAll();
					System.out.println("Consumed : " + gotInt);

				}
			}
			Thread.sleep(1000);
		}
		
	}

}
