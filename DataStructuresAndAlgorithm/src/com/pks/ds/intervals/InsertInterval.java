package com.pks.ds.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/description/
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {


    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int[] in : intervals) {
            // current interval is left of newInterval
            // eg: end of current interval is greater of start of newInterval
            if (in[1] > newInterval[0]) {
                result.add(in);
            } else if (in[0] > newInterval[1]) {
                // current interval is right of newInterval
                // eg: start of current interval is greater of end of newInterval
                result.add(newInterval);
                newInterval = in;
            } else {
                // means overlap, merge it
                // start : min of both start
                // end : max of both end
                newInterval[0] = Math.min(newInterval[0], in[0]);
                newInterval[1] = Math.max(newInterval[1], in[1]);
            }

        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
