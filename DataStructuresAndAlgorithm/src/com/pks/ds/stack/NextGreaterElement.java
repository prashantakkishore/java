package com.pks.ds.stack;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] input = { 63, 98, 23, 54, 12, 7, 20, 27, 64, 100 };
		nextGreaterElement(input);

	}

	public static void nextGreaterElement(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (stack.empty())
				stack.push(arr[i]);
			else {
				while (!stack.empty() && arr[i] > stack.peek()) {
					// Pop element
					System.out.println("Next greater element for "
							+ stack.pop() + " is " + arr[i]);

				}

				stack.push(arr[i]);

			}

		}

		// For remaining in stack is no greater element
		while (!stack.empty()) {
			System.out.println("Next greater element for " + stack.pop()
					+ " is " + "null");
		}
	}



}
