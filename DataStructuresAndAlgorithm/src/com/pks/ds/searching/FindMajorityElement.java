package com.pks.ds.searching;

/**
 * Element is in majority if that appears in more than n/2 times
 *
 */
public class FindMajorityElement {

	/**
	 * 1 - Refer MaxRepititions.java to get what number appears most.
	 * 2 - Second , do 1 more pass and see if majority num appears n/2 times.
	 */
	public static boolean isMajority(int []arr) {
		
		int num = MaxRepititions.maxRepititionsNum(arr);
		int count = 0;
		for (int i = 0 ; i < arr.length - 1 ; i ++){
			if(arr[i] == num)
				count ++;
		}
		
		if(count >= arr.length / 2)
			return true;
		else
			return false;
		
		
	}
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 5, 6, 1, 1, 2, 2, 1, 1, 1, 1, 7, 1, 1 };
		System.out.println(isMajority(arr));
	}

}
