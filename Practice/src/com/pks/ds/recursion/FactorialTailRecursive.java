package com.pks.ds.recursion;

public class FactorialTailRecursive {
	
	/**
	 A recursive function is tail recursive when recursive call is the 
	 last thing executed by the function
	 
	 A tail recursive function to calculate factorial
	 The idea is to use one more argument and accumulate
	 the factorial value in second argument (variable "a" here). 
	 When n reaches 0, return the accumulated value
		  
	**/
	
	static int factTR(int n, int a) {
		if (n == 0)
			return a;

		return factTR(n - 1, n * a);
	}

	// A wrapper over factTR
	static int fact(int n) {
		return factTR(n, 1);
	}

	// Driver code
	static public void main(String[] args) {
		System.out.println(fact(5));
	}
}
