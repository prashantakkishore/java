package com.pks.ds.lists;

public class NthFromLast {

	public static int i = 0;

	public int getNthFromLast_iterative(Node node, int n) {

		Node mainPtr = node;
		Node refPtr = node;

		int count = 0;
		while (count < n) {
			refPtr = refPtr.next;
			count++;
			if (refPtr == null)
				return -1;
		}

		while (refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}

		return mainPtr.data;

	}
	
	// No solution

//	public int getNthFromLast_recursive(Node node, int n) {
//
//		if (node != null) {
//			getNthFromLast_recursive(node.next, n);
//			i++;
//			if (i == n)
//				return node.data;
//		}
//		return -1;
//
//	}

	public static void main(String[] args) {

		NthFromLast list = new NthFromLast();

		Node node = new Node(85);
		node.next = new Node(15);
		node.next.next = new Node(4);
		node.next.next.next = new Node(20);

		int data = list.getNthFromLast_iterative(node, 2);
		System.out.println(data);
//		System.out.println(list.getNthFromLast_recursive(node, 2));
	}

}
