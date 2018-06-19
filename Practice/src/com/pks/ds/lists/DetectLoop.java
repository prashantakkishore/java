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
	
	 // Function to remove loop
    void removeLoop(Node loop, Node head) {
        Node ptr1 = loop;
        Node ptr2 = loop;
 
        // Count the number of nodes in loop
        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }
 
        // Fix one pointer to head
        ptr1 = head;
 
        // And the other pointer to k nodes after head
        ptr2 = head;
        for (i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }
 
        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
 
        // Get pointer to the last node
        ptr2 = ptr2.next;
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
 
        /* Set the next node of the loop ending node
         to fix the loop */
        ptr2.next = null;
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
