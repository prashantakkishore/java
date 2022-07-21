package com.pks.ds.lists;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
 */
public class RemoveDuplicatesInUnSortedList {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(12);
        node.next.next = new Node(11);
        node.next.next.next = new Node(11);
        node.next.next.next.next = new Node(12);
        node.next.next.next.next.next = new Node(11);
        node.next.next.next.next.next.next = new Node(12);
        removeDuplicate(node);
        printList(node);
    }

    public static Node removeDuplicate(Node head) {
        Set<Integer> mapping = new HashSet<>();
        Node curr = head;
        Node prev = null;
        while(curr != null ) {
            if (mapping.contains(curr.data)) {
                // same as prev.next = prev.next.next
                // prev and curr are adjacent
                prev.next = curr.next;
                curr = curr.next;
            } else {
                mapping.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void printList(Node node){
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}
