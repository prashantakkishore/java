package com.pks.ds.tree.BST;

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
*/
public class BSTBase {

	public static TreeNode root;
 
;	static {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		root = BuildBST.sortedArrayToBST(arr, 0, 8);
	}

}
