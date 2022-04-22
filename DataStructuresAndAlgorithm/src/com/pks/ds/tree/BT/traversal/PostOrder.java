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
 * Output : 4 5 2 6 7 3 1
 *
 */

public class PostOrder extends TreeBase {

	public static void recursive(TreeNode root) {
		if (root != null) {
			recursive(root.getLeft());
			recursive(root.getRight());
			System.out.print(root.getData() + " ");

		}
	}

	/**  TODO Not working
	 *
	 * @param root
	 */
	public static void iterative(TreeNode root) {

		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		TreeNode prev = null;
		while (!s.isEmpty()) {
			TreeNode curr = s.peek();
			if (prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
				// traverse from top to bottom, and if curr has left child or right child,
				// push into the stack; otherwise, pop out.
				if (curr.getLeft() != null)
					s.push(curr.getLeft());
				else if (curr.getRight() != null)
					s.push(curr.getRight());
			} else if (curr.getLeft() == prev) {
				if (curr.getRight() != null)
					s.push(curr.getRight());
			} else {
				System.out.print(root.getData() + " ");
				s.pop();
			}
			prev = curr;
		}
	}

	public static void main(String[] args) {
		recursive(root);
		//iterative(root);
	}

}
