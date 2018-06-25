package com.pks.ds.tree;

import java.util.Stack;

/**
 * Input : 
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 * 
 * Output : 4 2 5 1 6 3 7
 * 
 */

public class InOrder extends TreeBase {

	public static void recursive(TreeNode root) {
		if (root != null) {
			recursive(root.getLeft());
			System.out.print(root.getData() + " ");
			recursive(root.getRight());
		}
	}

	/**
	 * Use Stack for processing nodes
	 * 
	 * @param root
	 */
	public static void iterative(TreeNode root) {

		Stack<TreeNode> stack = new Stack<>();
		boolean done = false;
		
		while (!done) {
			
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				if (stack.empty())
					done = true;
				else {
					root = stack.pop();
					System.out.print(root.getData() + " ");
					root = root.getRight();
				}
			}
		}
	}

	public static void main(String[] args) {
		recursive(root);
		System.out.println("\n");
		iterative(root);
	}

}
