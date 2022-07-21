package com.pks.ds.lists;

import java.util.Objects;

public class Node {

	public int data;
	public Node next;

	Node(int d) {
		data = d;
		next = null;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Node node = (Node) o;
		return data == node.data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}
}
