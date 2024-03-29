package com.pks.java.design_patterns;

import java.util.LinkedList;
import java.util.Queue;

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
 *
 */
public class HitCounter {

    public static void main(String[] args) {

    }

    Queue<Integer> queue = new LinkedList<>();

    public void hit(int timestamp) {
        queue.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty()) {
            Integer val = queue.peek();
            if (val > 300)
                queue.remove();
            else break;
        }
        return queue.size();
    }
}
