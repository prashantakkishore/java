package com.pks.ds.stack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class KStacksInOneArray {

	static class KStack {

		int[] arr;
		int[] top;
		int[] next;
		int free = 0;

		public KStack(int noOfStacks, int arraySize) {

			arr = new int[arraySize];
			top = new int[noOfStacks];
			next = new int[arraySize];

			// All array element to -1 to show its empty
			IntStream.range(0, arr.length).forEach(i -> arr[i] = -1);

			// All top element to -1 to show its empty
			IntStream.range(0, top.length).forEach(i -> top[i] = -1);

			// Will show next free index
			IntStream.range(0, next.length).forEach(i -> next[i] = i + 1);
			// free index of last element is -1 , to indicate array is
			// completely full
			next[arraySize - 1] = -1;

		}

		public void push(int snum, int item) {
			// Overflow check
			if (isFull()) {
				System.out.println("Stack Overflow");
				return;
			}
			// next array will get free element
			int i = free;
			free = next[i];
			// At first top will be -1 , means stack ends
			next[i] = top[snum];
			top[snum] = i;
			
			

			arr[i] = item;

		}

		public int pop(int snum) {

			int i = top[snum];
			// update next to new top
			top[snum] = next[i];

			// adjust free
			next[i] = free;
			free = i;

			return arr[i];
		}

		public boolean isEmpty(int snum) {
			return top[snum] == -1;
		}

		public boolean isFull() {
			return (free == -1);
		}

	}

	public static void main(String[] args) {
		// Let us create 3 stacks in an array of size 10
		int k = 3, n = 10;

		KStack ks = new KStack(k, n);

		ks.push(2, 15);
		ks.push(2, 45);

		// Let us put some items in stack number 1
		ks.push(1, 17);
		ks.push(1, 49);
		ks.push(1, 39);

		// Let us put some items in stack number 0
		ks.push(0, 11);
		ks.push(0, 9);
		ks.push(0, 7);

		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}

}
