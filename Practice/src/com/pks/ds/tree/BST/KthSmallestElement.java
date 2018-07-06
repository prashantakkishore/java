package com.pks.ds.tree.BST;

import java.util.Stack;

import com.pks.ds.tree.TreeNode;
/**
* 
* Input : 1 2 3 4 5 6 7 8 9
* 
* Output : 
*	 			    5
*	 			 /    \
*	 		   2	    7
*	 		 /   \    /   \
*	 	   1	  3	 6	   8
*				   \		\
*  					4		 9
*  
*/
public class KthSmallestElement extends BSTBase {

	public static int iterative(TreeNode root, int k) {

		Stack<TreeNode> stack = new Stack<TreeNode>();

		int result = 0;

		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				TreeNode node = stack.pop();
				k--;
				if (k == 0)
					result = node.getData();
				root = node.getRight();
			}
		}

		return result;

	}

	public static void main(String[] args) {
		int k = 4;
		System.out.println(iterative(root, k));
	}

}
