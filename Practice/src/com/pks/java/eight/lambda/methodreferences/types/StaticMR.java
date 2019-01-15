package com.pks.java.eight.lambda.methodreferences.types;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.pks.java.eight.lambda.Person;

/**
 * This is same as {@code MethodReferencesBasics} where static references used
 * 
 * @author Prashantak
 *
 */

public class StaticMR {

	public static void main(String[] args) {
		List<Person> list = Person.createRoster();
		
		// 1
		filterByAge(list, new Predicate<Person>() {

			@Override
			public boolean test(Person p) {
				return p.getAge() > 25;
			}
		});
		
		// 2
		filterByAge(list, p -> p.getAge() > 25);
		
		//3 As we already have static method we can use as Method Reference 
		List<Person> persons = filterByAge(list, Person::isAgeMoreThan25);
		persons.forEach(System.out::println);
	}

	public static List<Person> filterByAge(List<Person> l, Predicate<Person> p) {
		List<Person> newList = new ArrayList<>();
		for (Person i : l) {
			if (p.test(i)) {
				newList.add(i);
			}
		}
		return newList;
	}

}
