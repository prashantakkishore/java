package com.pks.ds.tree.BST;

import com.pks.ds.tree.TreeNode;
/**
* 		O(h) : h = height of BST
*	 			    5
*	 			 /    \
*	 		   2	    7
*	 		 /   \    /   \
*	 	   1	  3	 6	   8
*				   \		\
*  					4		 9
*/
public class SearchNode extends BSTBase {

	public static boolean search(TreeNode root, int item) {
		if (root == null)
			return false;

		if (item == root.getData()) {
			return true;
		} else {
			if (item < root.getData()) {
				return search(root.getLeft(), item);
			} else {
				return search(root.getRight(), item);
			}
		}

	}

	public static void main(String[] args) {
		System.out.println(search(root, 10));
	}

}
