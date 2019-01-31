package com.pks.ds.tree;

public class TreeBase {
	
	public static TreeNode root;
	
	static {
		root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		// Set right nodes
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
			
	}

}
