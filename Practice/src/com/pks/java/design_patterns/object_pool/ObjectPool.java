package com.pks.java.design_patterns.object_pool;

import java.util.Enumeration;
import java.util.Hashtable;

abstract public class ObjectPool<T> {

	long deadTime;
	Hashtable<T, Long> inUse, unUsed;

	ObjectPool() {
		deadTime = 50000; // 50 seconds
		inUse = new Hashtable<T, Long>();
		unUsed = new Hashtable<T, Long>();
	}

	synchronized T takeOut() {

		long now = System.currentTimeMillis();
		T t;
		if (unUsed.size() > 0) {
			Enumeration<T> e = unUsed.keys();
			while (e.hasMoreElements()) {
				t = e.nextElement();
				if (now - unUsed.get(t) > deadTime) {
					unUsed.remove(t);
					destroy(t);
					t = null;
				} else {
					if (validate(t)) {
						unUsed.remove(t);
						inUse.put(t, now);
						return (t);
					} else {
						// object failed validation
						inUse.remove(t);
						destroy(t);
						t = null;
					}
				}

			}
		}

		// no objects available, create a new one
		t = create();
		inUse.put(t, now);
		return t;

	}

	synchronized void takeIn(T t) {
		inUse.remove(t);
		unUsed.put(t, System.currentTimeMillis());
	}

	abstract T create();

	abstract boolean validate(T o);

	abstract void destroy(T o);

}
