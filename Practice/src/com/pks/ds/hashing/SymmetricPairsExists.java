package com.pks.ds.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two pairs (a, b) and (c, d) are said to be symmetric if c is equal to b and a is equal to d. 
 * For example (10, 20) and (20, 10) are symmetric. 
 *
 */
public class SymmetricPairsExists {
	
	public static void findSymPairs(int arr[][]) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i][1])) {
				int value = map.get(arr[i][1]);
				if (value == arr[i][0]) {
					System.out.println("symmetric pair found : "
							+ Arrays.toString(arr[i]));
				}
			} else {
				map.put(arr[i][0], arr[i][1]);
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[][] = {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}};
		findSymPairs(arr);
	}

}
