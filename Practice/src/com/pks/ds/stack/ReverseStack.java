package com.pks.ds.stack;

import java.util.Stack;

public class ReverseStack {

	public Stack reverse(Stack stack) {
		if (!stack.isEmpty()) {
			Integer val = (Integer) stack.pop();
			reverse(stack);
			insert_at_bottom(stack,val);
		}
		return stack;
	}

	static void insert_at_bottom(Stack stack ,int x) {

		if (stack.isEmpty())
			stack.push(x);

		else {

			// All items are held in Function
			// Call Stack until we reach end
			// of the stack. When the stack becomes
			// empty, the st.size() becomes 0, the
			// above if part is executed and
			// the item is inserted at the bottom
			int a = (Integer)stack.pop();
			insert_at_bottom(stack,x);

			// push allthe items held
			// in Function Call Stack
			// once the item is inserted
			// at the bottom
			stack.push(a);
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println(stack);
		ReverseStack rStack = new ReverseStack();
		rStack.reverse(stack);
		System.out.println("Reversed: " + stack);

	}

}
