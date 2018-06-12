package com.pks.ds.arrays;

public class MaxProfit1Share {

	public static void main(String[] args) {
		
		int arr[] = { 5, 1, 4, 6, 7, 8, 4, 3, 7, 9 };
		System.out.println(getMaxBenefit(arr));
	}

	public static int getMaxBenefit(int[] S) {
		int maxBenefit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < S.length; i++) {
			maxBenefit = Math.max(maxBenefit, S[i] - minPrice);
			minPrice = Math.min(S[i], minPrice);
		}

		return maxBenefit;
	}

}
