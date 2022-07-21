package com.pks.ds.dp;

import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 *
 * https://leetcode.com/problems/word-break-ii/
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRecur(s, new HashSet<>(wordDict), 0, new boolean[s.length()]);
    }

    // O(n3) n time recursive call, n time for loop, n times substring
    private boolean wordBreakRecur(String s, HashSet<String> wordDict, int start, boolean[] cache) {

        if (start == s.length() -1)
            return true;
        if(cache[start] == true)
            return cache[start];

        for (int end = start + 1; end < s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end, cache)) {
                // Add cache memoization
                cache[start] = true;
                //return true;
            }
        }
        return cache[start] = false;
    }
}
