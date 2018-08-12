package com.pks.java.design_patterns;

import java.util.LinkedHashMap;
/**
 Another way of implementing it is using LinkedHashMap. It is an ordered Map. You can specify how you want to 
 order the map, by insertion or by access.  Although this is only possible in Java.

LinkedHashMap - keeps track of the order in which each entry is added.
By default, it removes the oldest entry when reached to a threshold.

1. In constructor - true flag - we are saying that, we want to remove the oldest element based on its access. 
(the one that was least accessed, should be removed)

2. In overridden method, we are saying that, remove entry only when we have reached cacheSize.
 */
public class LRUCache_2 extends LinkedHashMap<Integer, String> {
	
	private static final long serialVersionUID = 1L;
	private int cacheSize;
	 
	public LRUCache_2(int size) {
		// `true` means order hashmap by access
		super(size, 0.75f, true);
		this.cacheSize = size;
	}
 
	@Override
	protected boolean removeEldestEntry(
			java.util.Map.Entry<Integer,String> eldest) {
		// remove the oldest element when size limit is reached
		return size() > cacheSize;
	}
}
