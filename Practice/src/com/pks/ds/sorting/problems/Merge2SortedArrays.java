package com.pks.ds.sorting.problems;

import com.pks.ds.sorting.SortBase;

public class Merge2SortedArrays extends SortBase {

	public static void merge(int A[], int B[]) {
		
		int m = A.length;
		int n = B.length;
			 
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
	 
		while (k >= 0) {
			if (j < 0 || (i >= 0 && A[i] > B[j]))
				A[k--] = A[i--];
			else
				A[k--] = B[j--];
		}
	    
		
	}

	public static void main(String[] args) {
		int ar1[] = { 1, 5, 9, 10, 15, 20 };
		int ar2[] = { 2, 3, 8, 13 };
		merge(ar1, ar2);
		print(ar1);
		print(ar2);
	}
}
