package com.pks.java.eight;

public interface InterfaceExtensions {
	
	/**
	 * A Interface can have multiple "abstract" methods [as usual]
	 */
	public abstract void myTest1();
	
	
	/**
	 *  A Interface can have multiple "static" methods with implementations. [From Java 8 ]
	 */
	static void doSomething1() {
		
	}
	
	/**
	 *  A Interface can have multiple "default" methods with implementations. [From Java 8 ]
	 */
	default void doSomething2() {
		
	}
	
}
