package com.pks.ds.tree.BST;

import com.pks.ds.tree.TreeNode;
import com.pks.ds.tree.BT.traversal.InOrder;
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
*/
public class BuildBST {

	public static TreeNode sortedArrayToBST(int[] arr, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(arr[mid]);

		node.setLeft(sortedArrayToBST(arr, start, mid - 1));
		node.setRight(sortedArrayToBST(arr, mid + 1, end));

		return node;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode root = sortedArrayToBST(arr, 0, arr.length - 1);
		InOrder.recursive(root);
	}

}
