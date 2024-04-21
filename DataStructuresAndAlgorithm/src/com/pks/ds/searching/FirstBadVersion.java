package com.pks.ds.searching;

/**
 * https://leetcode.com/problems/first-bad-version/description/
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            // For very large int 2^31 - 1 this will go out of bounds
            // int mid = (left + right ) / 2;
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        // dummy , As this is implemented elsewhere
        return true;
    }


}
