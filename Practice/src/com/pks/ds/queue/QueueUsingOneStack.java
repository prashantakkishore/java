package com.pks.ds.queue;

import java.util.Stack;

/**
 * Implementing queue using Function Call Stack:
 * 
 * @author Prashantak
 *
 */

public class QueueUsingOneStack {

	static class Queue {

		Stack<Integer> stack = new Stack<Integer>();

		public void enQueue(int item) {
			stack.push(item);
		}

		public void deQueue() {
			
			Integer element = stack.pop();
			if (stack.size() >= 1) {
				deQueue(); // Recursive call
				stack.push(element);
			}
		}

		public void print() {
			System.out.println(stack);
		}
	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(60);

		queue.print();
		queue.deQueue();
		queue.deQueue();
		queue.enQueue(70);
		queue.print();
	}

}
