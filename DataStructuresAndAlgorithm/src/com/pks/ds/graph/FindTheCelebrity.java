package com.pks.ds.graph;

/**
 * https://leetcode.com/problems/find-the-celebrity/description/
 *
 * Example 1:
 * Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
 * Output: 1
 */
public class FindTheCelebrity {

    // O(n)
    public static int findCelebrity1(int n) {
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i))
                celebrityCandidate =  i;
        }
        if (isCelebrity(celebrityCandidate, n))
            return celebrityCandidate;
        else return -1;
    }

    // O(n^2)
    public static int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            if (isCelebrity(i, n))
                return i;
        }
        return -1;
    }

    private static boolean isCelebrity(int i, int n) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            if (!knows(j, i) && knows(i, j))
                return false;
        }
        return true;
    }

    private static boolean knows(int i, int j) {
        // predefined method
        return true;
    }


}
