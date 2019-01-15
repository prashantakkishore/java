package com.pks.java.eight.lambda.methodreferences.types;

import java.util.Collections;
import java.util.List;

import com.pks.java.eight.lambda.Person;

public class InstanceMRExistingObject {
	
	public static void main(String[] args) {
		
		List<Person> list = Person.createRoster();
		Person p = new Person(); // Existing object
		Collections.sort(list, p::compareByName);
		list.forEach(System.out::println);
	}
}
