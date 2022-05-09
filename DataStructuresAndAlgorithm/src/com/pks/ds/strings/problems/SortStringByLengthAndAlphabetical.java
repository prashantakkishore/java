package com.pks.ds.strings.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Just sort by length, for same length implict sort - alphabetical will be applied
 *
 * Input : [Apple, and, grape, are, not, aegetables]
 * Output: [and, are, not, Apple, grape, aegetables]
 */
public class SortStringByLengthAndAlphabetical {

    public static void main(String[] args) {
        String s = "Apple and grape are not egetables";
        SortStringByLengthAndAlphabetical e = new SortStringByLengthAndAlphabetical();
        e.display(s);
    }

    public void display(String str) {
        String[] st = str.split(" ");
        List<String> list = new ArrayList<>();
        for(String word: st){
            list.add(word);
        }
        System.out.println("Before sorting: " + list);
        Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        Collections.sort(list, comparator);
        System.out.println("After sorting: " + list);
    }
}
