package com.pks.java.eight.lambda.methodreferences.types;

import java.util.List;

import com.pks.java.eight.lambda.Person;

/**
 * This is also called "Parameter Method Reference" as one object is created by
 * JVM as calling Class type.
 * 
 * @author Prashantak
 *
 */
public class InstanceMRParticularType {

	public static void main(String[] args) {

		List<Person> list = Person.createRoster();
		// Here Person object is created by JVM and calls a non-static method
		list.forEach(Person::printEmail);

		// Complex scenario
		// We assume that Comparator takes 2 parameters to compare but here
		// "compareByNameParam"
		// takes only 1 argument, how it works ? Its because in this case JVM creates 1
		// object as calling object
		// and second is the object passed still 2 parameters passed.
		List<Person> list1 = Person.createRoster();
		list1.sort((p1, p2) -> p1.compareByNameParam(p2)); // To make more clear p1 is created by JVM
		list1.sort(Person::compareByNameParam);
		list.forEach(System.out::println);

	}

}
