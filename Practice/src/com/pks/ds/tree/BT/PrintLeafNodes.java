package com.pks.ds.tree.BT;

import java.util.ArrayList;
import java.util.List;

import com.pks.ds.tree.TreeBase;
import com.pks.ds.tree.TreeNode;
/**
 * Input : 
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 * 
 * Output : 4 5 6 7
 * 
 */
public class PrintLeafNodes extends TreeBase {

	public static void printNodes(TreeNode root, List<Integer> leafNodes) {

		if (root == null)
			return;

		if (root.isLeaf())
			leafNodes.add(root.getData());

		printNodes(root.getLeft(), leafNodes);
		printNodes(root.getRight(), leafNodes);

	}

	public static void main(String[] args) {
		List<Integer> leafNodes = new ArrayList<Integer>();
		printNodes(root, leafNodes);
		System.out.println(leafNodes);

	}

}
