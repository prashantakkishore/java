package com.pks.java.eight.streams;

import java.util.List;
import java.util.stream.Stream;

import com.pks.java.eight.lambda.Person;

/**
 * 1 - Map operation takes one type of Stream and converts to another
 * 2 - It is an intermediary operation
 * 3 - It takes "Function" as argument
 *
 */

public class MapOperation {

	public static void main(String[] args) {
		List<Person> list = Person.createRoster();
		Stream<Person> person =  list.stream();
		Stream<String> names = person.map(p -> p.getName()); // 1 - This doesn't do anything
		
		/////
		Stream<Person> person1 =  list.stream();
		person1.map(p -> p.getName()).forEach(System.out::println); // forEach is a final operation so it 
		//starts the stream processing and prints all names

	}

}
