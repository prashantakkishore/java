package com.pks.ds.tree.BT;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.pks.ds.tree.TreeBase;
import com.pks.ds.tree.TreeNode;
/**
 *
 * Input :
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 *
 * Output : 1 3 2 4 5 6 7
 *
 */
public class ZigZagTraversalBT extends TreeBase{

	public static void iterativeQueue(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int count = queue.size();
			boolean direction = true;
			while (count > 0) {
				TreeNode node = queue.poll();
				System.out.println(node.getData());
				if (!direction) {
					if (node.getLeft() != null)
						queue.add(node.getLeft());
					if (node.getRight() != null)
						queue.add(node.getRight());
				} else {
					if (node.getRight() != null)
						queue.add(node.getRight());
					if (node.getLeft() != null)
						queue.add(node.getLeft());
				}
				count--;
			}

			direction = !direction;

		}
	}

	public static void iterative(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		boolean direction = false;
		while (!stack.isEmpty()) {

			Stack<TreeNode> tempStack = new Stack<>();

			while (!stack.empty()) {
				TreeNode node = stack.pop();
				System.out.println(node.getData());
				if (!direction) {
					if (node.getLeft() != null)
						tempStack.push(node.getLeft());
					if (node.getRight() != null)
						tempStack.push(node.getRight());
				} else {
					if (node.getRight() != null)
						tempStack.push(node.getRight());
					if (node.getLeft() != null)
						tempStack.push(node.getLeft());
				}

			}
			direction = !direction;
			stack = tempStack; // Assign stack
		}

	}


	public static void main(String[] args) {
		iterative(root);

	}

}
