package com.pks.ds.tree.BT.traversal;

import java.util.Stack;

import com.pks.ds.tree.TreeBase;
import com.pks.ds.tree.TreeNode;

/**
 *
 * Input :
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 *
 * Output :
 * 1 2 4 5 3 6 7
 *
 */

public class PreOrder extends TreeBase {

	public static void recursive(TreeNode root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			recursive(root.getLeft());
			recursive(root.getRight());
		}
	}

	/**
	 * Use Stack for processing nodes
	 * @param root
	 */
	public static void iterative(TreeNode root) {

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.println(node.getData());
			if (node.getRight() != null)
				stack.push(node.getRight());
			if (node.getLeft() != null)
				stack.push(node.getLeft());

		}
	}

	public static void main(String[] args) {
		recursive(root);
		iterative(root);
	}

}
