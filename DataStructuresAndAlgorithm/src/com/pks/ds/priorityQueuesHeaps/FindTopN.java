package com.pks.ds.priorityQueuesHeaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindTopN {

	public static void topN(int arr[], int topN) {

		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(topN);
		Arrays.stream(arr).forEach(i -> {
			pQueue.add(i);
			if (pQueue.size() > topN) {
				pQueue.poll();
			}
		});

		System.out.println(pQueue);

	}
	
	public static void main(String[] args) {
		int A[] = { 8, 4, 45, 6, 10, 8 };
		int n = 3;
		topN(A, n);

	}

}
