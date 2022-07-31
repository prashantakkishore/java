package com.pks.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/meeting-scheduler/
 */
public class MeetingScheduler {

    public static void main(String[] args) {
        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slots2 = {{0, 15}, {60, 70}};
        int duration = 8;
        System.out.println(minAvailableDuration(slots1, slots2, duration));
    }

    public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));
        int p1 = 0, p2 = 0;
        while (p1 < slots1[0].length && (p2 < slots2[0].length)) {
            int startMax = Math.max(slots1[p1][0], slots2[p2][0]);
            int endMin = Math.min(slots1[p1][1], slots2[p2][1]);
            if (endMin - startMax >= duration) {
                return Arrays.asList(startMax, startMax + duration);
            }
            // shorter end time moves
            if (slots2[p2][1] > slots1[p1][1])
                p1++;
            else
                p2++;
        }

        return new ArrayList<>();
    }
}
