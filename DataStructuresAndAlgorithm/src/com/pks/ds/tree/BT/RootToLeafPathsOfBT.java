package com.pks.ds.tree.BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.pks.ds.tree.TreeBase;
import com.pks.ds.tree.TreeNode;

/**
 * Uses "InOrder" Traversal of BT and while traversing just saves node
 * Once it reaches leaf it prints the path.
 *
 * Input :
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 *
 * Output :
 * 1 -> 2 -> 4
 * 1 -> 2 -> 5
 * 1 -> 3 -> 6
 * 1 -> 3 -> 7
 *
 */

public class RootToLeafPathsOfBT extends TreeBase {

	public static void recursive(TreeNode root, List<Integer> path) {

		path.add(root.getData());

		if (root.getLeft() == null && root.getRight() == null){
			path.forEach(data -> System.out.print(data + "->"));
			System.out.println();
		}
		else {

			recursive(root.getLeft(), new ArrayList<Integer>(path));
			recursive(root.getRight(), new ArrayList<Integer>(path));

		}

	}

	/**
	 * Use Stack for processing nodes
	 * @param root
	 */
	public static void iterative(TreeNode root) {

		Stack<Object> stack = new Stack<>();
		stack.push(root);
		stack.add(root.getData() + "");

		while (!stack.isEmpty()) {

			String headPath = (String) stack.pop();
			TreeNode node = (TreeNode) stack.pop();

			if (node.isLeaf()) {
				System.out.print(headPath);
				System.out.println();
			} else {
				if (node.getRight() != null) {

					stack.push(node.getRight());
					stack.push(headPath + "->" + node.getRight().getData());
				}
				if (node.getLeft() != null) {
					stack.push(node.getLeft());
					stack.push(headPath + "->" + node.getLeft().getData());

				}
			}

		}
	}

	public static void main(String[] args) {
		recursive(root, new ArrayList<Integer>());
		//iterative(root);

	}

}
