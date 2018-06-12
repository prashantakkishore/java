package com.pks.ds.lists;

public class PrintFromEnd {

	public void printFromEnd(Node node) {

		if (node.next != null)
			printFromEnd(node.next);

		System.out.println(node.data);
	}

	public static void main(String[] args) {
		PrintFromEnd list = new PrintFromEnd();

		Node node = new Node(85);
		node.next = new Node(15);
		node.next.next = new Node(4);
		node.next.next.next = new Node(20);

		System.out.println("Given Linked list");
		list.printFromEnd(node);
	}
}
