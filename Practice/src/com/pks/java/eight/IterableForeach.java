package com.pks.java.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.pks.java.eight.lambda.Person;

public class IterableForeach {

	public static void main(String[] args) {

		List<Person> list = Person.createRoster();
		
		List<Person> list2 = new ArrayList<>();
		
		// forEach takes a Consumer
		Consumer<Person> c1 = person -> System.out.println(person);
		// or method reference
		Consumer<Person> c2 = System.out::println;
		Consumer<Person> c3 = list2::add;

		list.forEach(person -> System.out.println(person));
		// Consumer chaining
		list.forEach(c2.andThen(c3)); // First prints all persons and adds to new list
		System.out.println(list2.size()); // 8
		
		
		

	}

}
