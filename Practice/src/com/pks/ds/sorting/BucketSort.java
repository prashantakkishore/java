package com.pks.ds.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Java Program sort an integer array using radix sort algorithm. 
 * input: [80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50] 
 * output: [0, 10, 20, 30, 40, 50, 50, 60, 70, 80, 90] 
 *  
 * Time Complexity of Solution: * Best Case O(n); Average Case O(n); Worst Case O(n^2). 
 * 
 * Not in place
 * Not Stable
 * 
 */

public class BucketSort extends SortBase {
	public static void main(String[] args) {

		int[] input = { 80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50 };

		bucketSort(input);
		print(input);
	}

	public static void bucketSort(int[] input) {
		// get hash codes
		final Integer[] code = hash(input);
		// create and initialize buckets to ArrayList: O(n)
		List<Integer>[] buckets = new List[code[1]];
		for (int i = 0; i < code[1]; i++) {
			buckets[i] = new ArrayList();
		}
		// distribute data into buckets: O(n)
		for (int i : input) {
			buckets[hash(i, code)].add(i);
		}
		// sort each bucket O(n)
		for (List bucket : buckets) {
			Collections.sort(bucket);
		}
		int ndx = 0;
		// merge the buckets: O(n)
		for (int b = 0; b < buckets.length; b++) {
			for (int v : buckets[b]) {
				input[ndx++] = v;
			}
		}
	}

	private static Integer[] hash(int[] input) {
		int m = input[0];
		for (int i = 1; i < input.length; i++) {
			if (m < input[i]) {
				m = input[i];
			}
		}
		return new Integer[] { m, (int) Math.sqrt(input.length) };
	}
	/**
	 * 
	 * @param i
	 * @param code
	 * @return
	 */
	private static int hash(Integer i, Integer[] code) {
		return (int) ((double) i / code[0] * (code[1] - 1));
	}

}