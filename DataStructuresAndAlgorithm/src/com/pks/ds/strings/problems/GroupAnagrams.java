package com.pks.ds.strings.problems;

import javax.xml.stream.events.Characters;
import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagrams {

    public static void main(String[] args) {
       String[] strs = {"eat","tea","tan","ate","nat","bat"};
        //System.out.println(groupAnagramsSort(strs));
        System.out.println(groupAnagramsHash(strs));

    }

    /**
     * Complexity: N-words and each word has a maximum of M characters.
     * The upper bound is O(NMLogM + MNLogN)
     */
    public static List<List<String>> groupAnagramsSort(String[] strs) {
        Map<String, List<String>> grpMap = new HashMap<>();
        for (String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedWord = String.valueOf(chars);
            if(!grpMap.containsKey(sortedWord)){
                grpMap.put(sortedWord, new ArrayList<>());
            }
            grpMap.get(sortedWord).add(str);
        }
        return new ArrayList<>(grpMap.values());
    }


    /**
     *  O(NM)
     */
    public static List<List<String>> groupAnagramsHash(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray())
                count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                //sb.append('#');
                sb.append(count[i]);
            }
            // eg: "eat" = "10001000000000000001000000"
            String key = sb.toString();
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


}
