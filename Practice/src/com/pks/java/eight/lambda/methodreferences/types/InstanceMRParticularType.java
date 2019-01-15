package com.pks.java.eight.lambda.methodreferences.types;

import java.util.List;

import com.pks.java.eight.lambda.Person;

public class InstanceMRParticularType {

	public static void main(String[] args) {

		List<Person> list = Person.createRoster();
		// Here Person object is created by JVM and calls a non-static method
		list.forEach(Person::printEmail);
	}

}
