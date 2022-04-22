package com.pks.ds.tree.BST;

import com.pks.ds.tree.TreeNode;
import com.pks.ds.tree.BT.traversal.InOrder;
/**
*
* Input : 1 2 3 4 5 6 7 8 9
* Insert : 10
*
* Output :
*	 			    5
*	 			 /    \
*	 		   2	    7
*	 		 /   \    /   \
*	 	   1	  3	 6	   8
*				   \		\
*  					4		 9
*  							  \
*  							   10
*/
public class InsertNode extends BSTBase {

	public static TreeNode insertNode(TreeNode root, int item) {

		if (root == null) {
			TreeNode node = new TreeNode(item);
			root = node;
			return root;

		} else {

			if (item < root.getData())
				root.setLeft(insertNode(root.getLeft(), item)); // set left
			else
				root.setRight(insertNode(root.getRight(), item)); // set right

		}

		return root;
	}

	public static void main(String[] args) {
		TreeNode node = insertNode(root, 10);
		InOrder.recursive(node);

	}

}
