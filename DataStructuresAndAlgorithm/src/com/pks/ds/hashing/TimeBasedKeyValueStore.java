package com.pks.ds.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/time-based-key-value-store/description/
 * Input
 * ["TimeMap", "set", "get", "get", "set", "get", "get"]
 * [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
 * Output
 * [null, null, "bar", "bar", null, "bar2", "bar2"]
 */
public class TimeBasedKeyValueStore {

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
    }

    public static class TimeMap {
        Map<String, TreeMap<Integer, String>> store = new HashMap<>();

        public void set(String key, String value, int timestamp) {
            if (store.containsKey(key)) {
                TreeMap<Integer, String> timeData = store.get(key);
                timeData.put(timestamp, value);
            } else {
                TreeMap<Integer, String> timeData = new TreeMap<>();
                timeData.put(timestamp, value);
                store.put(key, timeData);
            }
        }

        public String get(String key, int timestamp) {
            if (store.containsKey(key)) {
                TreeMap<Integer, String> timeData = store.get(key);
                // this give key nearest to given key if not found the key, where nearestKey <= key
                Integer nearestKey = timeData.floorKey(timestamp);
                return timeData.get(nearestKey);
            } else {
                return "";
            }
        }
    }
}
