package com.pks.ds.sorting.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        int K = 4;
        // array to store head of linkedlist
        Node[] a = new Node[K];
        // Linkedlist1
        Node head1 = new Node(1);
        a[0] = head1;
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        // Limkedlist2
        Node head2 = new Node(4);
        a[1] = head2;
        head2.next = new Node(5);
        // Linkedlist3
        Node head3 = new Node(5);
        a[2] = head3;
        head3.next = new Node(6);
        // Linkedlist4
        Node head4 = new Node(7);
        a[3] = head4;
        head4.next = new Node(8);

        Node res = mergeKList(a, K);

        if (res != null)
            printList(res);
        System.out.println();


    }

    private static void printList(Node res) {
        while(res!=null){
            System.out.println(res + "->");
            res = res.next;
        }
    }

    // O(nLogk)
    private static Node mergeKList(Node[] a, int k) {
        Comparator<Node> comparator = (x,y) -> {
            if(x.data > y.data) return 1;
            if(x.data < y.data) return -1;
            else return 0;
        };
        Node result = new Node(-1);
        Node head = result;
        PriorityQueue<Node> queue = new PriorityQueue(comparator);


        for (int i = 0; i < k; i++) {
            queue.add(a[i]);
        }
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            result.next = node;
            result = result.next;
            if (node != null && node.next!= null)
                queue.add(node.next);
        }
        return head.next;
    }


    static class Node {
        Node next;
        Integer data;

        public Node(Integer data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }


}
