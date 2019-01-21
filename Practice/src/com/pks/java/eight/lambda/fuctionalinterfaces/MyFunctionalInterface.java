package com.pks.java.eight.lambda.fuctionalinterfaces;

/**
 * 
 * Annotating interface as @FunctionalInterface is just for convenience that way compiler
 * can throw error if any Interface is not FunctionalInterface. Like having 2 abstract methods.
 *
 */

@FunctionalInterface
public interface MyFunctionalInterface {
	
	/**
	 * FunctionalInterface can have a single "abstract" method.
	 */
	void doSomething();
	
	/**
	 * FunctionalInterface can have multiple "static" methods.
	 */
	static void doSomething1() {
		
	}
	
	/**
	 * FunctionalInterface can have multiple "default" methods.
	 */
	default void doSomething2() {
		
	}
	
	/**
	 * An exception
	 */
	boolean equals(Object o); // This is method from Object class so wont count as another abstract method

}
