package com.pks.java.design_patterns;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/design-hit-counter/
 * Design a hit counter which counts the number of hits received in the past 5 minutes
 * (i.e., the past 300 seconds).
 *
 * Your system should accept a timestamp parameter (in seconds granularity), and you may assume
 * that calls are being made to the system in chronological order (i.e., timestamp is monotonically
 * increasing). Several hits may arrive roughly at the same time.
 *
 * Implement the HitCounter class:
 *
 * HitCounter() Initializes the object of the hit counter system.
 * void hit(int timestamp) Records a hit that happened at timestamp (in seconds). Several hits
 * may happen at the same timestamp.
 * int getHits(int timestamp) Returns the number of hits in the past 5 minutes from timestamp
 * (i.e., the past 300 seconds).
 *
 *  =========================
 *  --- We can optimize Approach 1 even further. In this approach, we'll not only keep the
 *  timestamps but will also keep the count of the timestamps as well.
 *
 */
public class HitCounter2 {

    public static void main(String[] args) {
        HitCounter2 counter = new HitCounter2();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));
        counter.hit(300);     // hit at timestamp 300.
        System.out.println(counter.getHits(300)); // get hits at timestamp 300, return 4.
        System.out.println(counter.getHits(301));
    }


    private int total;
    private Deque<Pair<Integer, Integer>> hits;

    /** Initialize your data structure here. */
    public HitCounter2() {
        // Initialize total to 0
        this.total = 0;
        this.hits = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (this.hits.isEmpty() || this.hits.getLast().getKey() != timestamp) {
            // Insert the new timestamp with count = 1
            this.hits.add(new Pair<Integer, Integer>(timestamp, 1));
        } else {
            // Update the count of latest timestamp by incrementing the count by 1

            // Obtain the current count of the latest timestamp
            int prevCount = this.hits.getLast().getValue();
            // Remove the last pair of (timestamp, count) from the deque
            this.hits.removeLast();
            // Insert a new pair of (timestamp, updated count) in the deque
            this.hits.add(new Pair<Integer, Integer>(timestamp, prevCount + 1));
        }
        // Increment total
        this.total++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!this.hits.isEmpty()) {
            int diff = timestamp - this.hits.getFirst().getKey();
            if (diff >= 300) {
                // In this case for 1 its 300 so its not in 300 range so remove that.
                // Decrement total by the count of the "oldest" timestamp
                this.total -= this.hits.getFirst().getValue();
                this.hits.removeFirst();
            }
            else {
                System.out.println("In range");
                break;
            }
        }
        return this.total;
    }

    static class Pair<T,V> {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
