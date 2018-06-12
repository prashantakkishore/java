package com.pks.ds.lists;

import java.util.HashSet;

public class DetectLoop {
	
	public static boolean detectLoop_hashing(Node h)
    {
        HashSet<Node> s = new HashSet<Node>();
        while (h != null)
        {
             // If we have already has this node
             // in hashmap it means their is a cycle
             // (Because you we encountering the
             // node second time).
            if (s.contains(h))
                return true;
   
            // If we are seeing the node for
            // the first time, insert it in hash
            s.add(h);
   
            h = h.next;
        }
   
        return false;
    }
	
	/**
	 * Floyd’s Cycle-Finding Algorithm
	 * @return
	 */
	
	public static boolean detectLoop_pointers(Node head)
    {
        Node slow_p = head, fast_p = head;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                System.out.println("Found loop");
                return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		Node node = new Node(85);
        node.next = new Node(15);
        node.next.next = new Node(4);
        node.next.next.next = new Node(20);
          
        /*Create loop for testing */
        node.next.next = node.next;
  
        if (detectLoop_hashing(node))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
        
        if (detectLoop_pointers(node))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
        
        
	}

}
