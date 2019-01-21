package com.pks.java.eight.streams;

import java.util.List;
import java.util.function.Predicate;

import com.pks.java.eight.lambda.Person;

/**
 * 1 - Filter operation takes a argument and returns boolean
 * 2 - It is an intermediary operation
 * 3 - It takes "Predicate" as argument
 *
 */
public class FilterOperation {

	public static void main(String[] args) {
		List<Person> list = Person.createRoster();
		
		Predicate<Person> predicate = p -> p.getAge() > 25;
		
		list.stream()
			.filter(predicate)
			.forEach(System.out::println);

	}

}
