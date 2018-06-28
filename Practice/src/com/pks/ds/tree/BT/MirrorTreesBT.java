package com.pks.ds.tree.BT;

import com.pks.ds.tree.TreeBase;
import com.pks.ds.tree.TreeNode;

public class MirrorTreesBT extends TreeBase{
	
	public static boolean areMirror(TreeNode a, TreeNode b) {
		/* Base case : Both empty */
		if (a == null && b == null)
			return true;

		// If only one is empty
		if (a == null || b == null)
			return false;

		/*
		 * Both non-empty, compare them recursively Note that in recursive
		 * calls, we pass left of one tree and right of other tree
		 */
		return a.getData() == b.getData()
				&& areMirror(a.getLeft(), b.getRight())
				&& areMirror(a.getRight(), b.getLeft());
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(1);
        a.setLeft( new TreeNode(2));
        a.setRight( new TreeNode(3));
        a.getLeft().setLeft(new TreeNode(4));
        a.getLeft().setRight(new TreeNode(5));
 
        b.setLeft(new TreeNode(3));
        b.setRight(new TreeNode(2));
        b.getRight().setLeft(new TreeNode(5));
        b.getRight().setRight( new TreeNode(4));
		
		
		System.out.println(areMirror(a, b));

	}

}
