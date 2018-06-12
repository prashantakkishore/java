package com.pks.multithreading;

import java.util.ArrayList;
import java.util.List;

public class TenThreads extends Thread {

	int modNum;
	Object lock;
	static int currentNumValue = 1;

	public TenThreads(String threadName, int modNum, Object lock) {
		super.setName(threadName);
		this.modNum = modNum;
		this.lock = lock;
	}

	public void run() {
		synchronized (lock) {
			try {
				while (true) {
					while (currentNumValue % 10 != modNum) {
						lock.wait();
					}
					if (currentNumValue == 101) {
						break;
					} else {
						System.out.println(Thread.currentThread().getName()
								+ " : " + currentNumValue);
						currentNumValue = currentNumValue + 1;
						lock.notifyAll();
					}

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		List<TenThreads> tList = new ArrayList<TenThreads>();
		Object lock = new Object();
		for (int i = 0; i < 10; i++) {
			TenThreads t1 = new TenThreads("Thread P" + i, i, lock);
			tList.add(t1);
		}
		for (TenThreads a : tList) {
			a.start();
		}
	}

}
