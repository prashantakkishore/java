package com.pks.ds.sorting.problems;

import com.pks.ds.sorting.SortBase;

public class RemoveDuplicatesSortedArray extends SortBase {

	public static int removeDuplicates(int[] A) {
		int len = A.length;
		int i = 0;
		if (len <= 1)
			return len;
		for (int j = 1; j < len; j++) {
			if (A[j] != A[i])
				A[++i] = A[j];
		}
		return i + 1;
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 3, 4, 5, 5, 6, 7, 10, 11, 11 };
		System.out.println(A.length);
		System.out.println(removeDuplicates(A));
		print(A);
	}
}
