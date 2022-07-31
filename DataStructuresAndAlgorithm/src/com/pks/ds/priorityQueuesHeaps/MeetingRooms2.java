package com.pks.ds.priorityQueuesHeaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public static void main(String[] args) {
        Intervals[] intervals = {
                new Intervals(0, 30), new Intervals(5, 10),
                new Intervals(15, 20)};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(Intervals[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, Comparator.comparing(i -> i.start));
        PriorityQueue<Intervals> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i.end));
        // Same as above
        // PriorityQueue<Intervals> minHeap = new PriorityQueue<>((i, j ) -> i.end - j.end);
        minHeap.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Intervals current = intervals[i];
            Intervals earliest = minHeap.remove();
            if (current.start > earliest.end) {
                earliest.end = current.end;
            } else {
                minHeap.add(current);
            }
            minHeap.add(earliest);
        }

        return minHeap.size();

    }


    static class Intervals {
        int start;
        int end;

        public Intervals(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Intervals() {
            this.start = 0;
            this.end = 0;
        }
    }
}
