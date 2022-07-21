package com.pks.ds.priorityQueuesHeaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindTopN {

	public static void main(String[] args) {
		int A[] = { 8, 4, 45, 6, 10, 8 , 9 , 50 , 43, 13, 22, 88, 73, 55,47};
		int n = 3;
		topN(A, n);

	}

	public static void topN(int arr[], int topN) {

		// default is ascending, 1,2,3 -> q.remove will remove 1
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(topN);
		Arrays.stream(arr).forEach(i -> {
			pQueue.add(i);
			if (pQueue.size() > topN) {
				pQueue.remove();
			}
		});

		System.out.println(pQueue);

	}



}
