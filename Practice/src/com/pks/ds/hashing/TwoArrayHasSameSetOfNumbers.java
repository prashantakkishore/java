package com.pks.ds.hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoArrayHasSameSetOfNumbers {

	private static void sameSetOfNumbers(int[] arr, int[] arr1) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		for (int i = 0; i < arr1.length; i++) {
			if (map.containsKey(arr1[i])) {
				map.put(arr1[i], map.get(arr1[i]) - 1);
			} else {
				System.out.println("Set not equal");
			}
		}

		int sum = map.values().stream().mapToInt(i -> i).sum();
		if (sum == 0)
			System.out.println("Set equal");

	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 6, 8, 10, 2, 2 };
		int[] arr1 = { 2, 2, 5, 8, 10, 2, 6 };

		sameSetOfNumbers(arr, arr1);

	}

}
