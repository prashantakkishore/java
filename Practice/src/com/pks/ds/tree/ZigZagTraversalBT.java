package com.pks.ds.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * 
 * Input : 
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 * 
 * Output : 1 3 2 4 5 6 7
 * 
 */
public class ZigZagTraversalBT extends TreeBase{

	public static void iterative(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		boolean direction = false;
		while (!stack.isEmpty()) {

			Stack<TreeNode> tempStack = new Stack<>();

			while (!stack.empty()) {
				TreeNode node = stack.pop();
				System.out.println(node.getData());
				if (!direction) {
					if (node.getLeft() != null)
						tempStack.push(node.getLeft());
					if (node.getRight() != null)
						tempStack.push(node.getRight());
				} else {
					if (node.getRight() != null)
						tempStack.push(node.getRight());
					if (node.getLeft() != null)
						tempStack.push(node.getLeft());
				}
				
			}
			direction = !direction;
			stack = tempStack; // Assign stack
		}

	}

	public static void main(String[] args) {
		iterative(root);

	}

}
