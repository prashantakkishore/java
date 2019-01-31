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
public class InOrderSuccessor extends BSTBase{

	
	public static TreeNode iterative(TreeNode root, TreeNode node) {
		/**
		 * 1) If right subtree of node is not NULL, then succ lies in left
		 * subtree of right child. Do following. Go to left subtree of right
		 * child and return the node with minimum key value in right subtree.
		 */
		if (node.getRight() != null) {
			node = node.getRight();
			while (node.getLeft() != null) {
				node = node.getLeft();
			}
			return node;
		} else {
			/**
			 * 2) If right subtree of node is NULL, then start from root and get
			 * parent. Do following. Travel down the tree, if a node’s data is
			 * greater than root’s data then go right side, otherwise go to left
			 * side.
			 */
			TreeNode succ = null;
			while (root != null) {
				if (node.getData() < root.getData()) {
					succ = root;
					root = root.getLeft();
				} else if (node.getData() > root.getData())
					root = root.getRight();
				else
					break;
			}
			return succ;
		}

	}
	
	public static void main(String[] args) {
//		TreeNode node = iterative(root, root);
//		TreeNode node = iterative(root, root.getLeft().getRight().getRight());
//		TreeNode node = iterative(root, root.getRight().getLeft());
		TreeNode node = iterative(root, root.getRight().getRight().getRight());
		System.out.println(node.getData());
	}

}
