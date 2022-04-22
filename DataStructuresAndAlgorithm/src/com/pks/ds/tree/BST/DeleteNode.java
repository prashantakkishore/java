package com.pks.ds.tree.BST;

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
public class DeleteNode extends BSTBase {

	public static void main(String[] args) {
		InOrder.recursive(root);
	}

}
