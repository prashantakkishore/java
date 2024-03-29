package com.pks.ds.dp;

/**
 * https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 * Solution: https://www.youtube.com/watch?v=Pk128gC_sdw
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n.
 * (i.e The length of the garden is n).
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap
 * can water the area [i - ranges[i], i + ranges[i]] if it was open.
 * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered
 * return -1.
 */
public class MinTapsToOpenToWaterGarden {

    public static void main(String[] args) {

        System.out.println(minTaps(5, new int[]{3, 2, 1, 1, 1, 0}));
    }


    public static int minTaps(int gardenLength, int[] ranges) {

        int min = 0;
        int max = 0;
        int taps = 0;

        while(max < gardenLength) {
            for (int i = 0; i < ranges.length; i++) {
                if ((i - ranges[i]) <= min && (i + ranges[i]) > max)
                    max = (i + ranges[i]);
            }
            if (min == max) return -1;
            taps++;
            min = max;
        }
        return taps;
    }
}
