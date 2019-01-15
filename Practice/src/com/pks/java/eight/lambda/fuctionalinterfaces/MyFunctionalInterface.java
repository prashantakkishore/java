package com.pks.java.eight.lambda.fuctionalinterfaces;

/**
 * 
 * Annotating interface as @FunctionalInterface is just for convenience that way compiler
 * can throw error if any INterface is not FunctionalInterface.
 *
 */

@FunctionalInterface
public interface MyFunctionalInterface {
	
	void doSomething();
	
	boolean equals(Object o); // This is method from Object class so wont count as another abstract method

}
