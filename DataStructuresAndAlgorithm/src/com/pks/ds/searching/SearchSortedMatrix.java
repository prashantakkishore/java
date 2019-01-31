package com.pks.ds.searching;
/**
Input : mat[4][4] = { 	{10, 20, 30, 40},
        				{15, 25, 35, 45},
        				{27, 29, 37, 48},
        				{32, 33, 39, 50}};
x = 29
Output : Found at (2, 1)

Input : mat[4][4] = { 	{10, 20, 30, 40},
        				{15, 25, 35, 45},
        				{27, 29, 37, 48},
        				{32, 33, 39, 50}};
x = 100
Output : Element not found
**/
public class SearchSortedMatrix {
	
	public static void main(String[] args) {
        int mat[][] = { {10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50} };
         
        search(mat, 4, 54);
     }

	private static void search(int[][] mat, int dim, int num) {
		
		int s = 0, e = dim -1 ;
		while(s < dim && e != 0){
			
			if(num == mat[s][e]){
				System.out.println("Found at " + s +" "+ e);
				return;
			}
			if(num < mat[s][e])
				e--;
			if(num > mat[s][e])
				s++;
			
		}
		System.out.print("Element not found");
		return;
		
	}
}
