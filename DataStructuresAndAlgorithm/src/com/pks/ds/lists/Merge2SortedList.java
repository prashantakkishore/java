package com.pks.ds.lists;


public class Merge2SortedList {

	public static void main(String[] args) {
		Node one = new Node(1, new Node(3, new Node(5, null)));
		Node two = new Node(2, new Node(4, new Node(6, null)));
		Node p = mergeTwoLists(one, two);
		print(p);
	}

	public static void print(Node p){
		while (p != null) {
			System.out.println(p.data);
			p = p.next;
		}
	}

	public static Node mergeTwoLists(Node l1, Node l2){
		Node dummy = new Node(-1, null);
		Node p = dummy;
		while (l1 != null && l2 != null) {
			if (l1.data < l2.data) {
				p.next = l1;
				l1 = l1.next;
			} else if (l1.data > l2.data) {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		return dummy.next;

	}

	static class Node{
		int data;
		Node next;
		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}

}
