package com.pks.ds.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://www.youtube.com/watch?v=i2bBG7CaVxs
 */
public class MeetingRooms {

    public static void main(String[] args) {
        Intervals[] intervals = {
                new Intervals(0,30), new Intervals(5,10),
                new Intervals(15,20)};
        System.out.println(canAttendMeetingsComparator(intervals));
    }


    // O(nlogn)
    // Space O(1)
    public static boolean canAttendMeetingsComparator(Intervals[] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));
        // Arrays.sort(intervals, (i,j) -> Integer.compare(i.start, j.start)); // Also can be used
        for (int i = 1; i < intervals.length; i++) {
            // start is more than next end
            if(intervals[i ].start < intervals[i - 1].end)
                return false;
        }
        return true;
    }

    // O(nlogn)
    // Space O(n)
    public static boolean canAttendMeetings(Intervals[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0; i < intervals.length -1; i++) {
            // start is more than next end
            if(start[i +1 ] < end[i])
                return false;
        }

        return true;

    }

    static class Intervals{
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
