package com.pks.java.eight.lambda.methodreferences;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.pks.java.eight.lambda.Person;

public class MethodReferencesBasics {

	public static void main(String[] args) {

		////////////////// Anonymous class ///////////////
		
		List<Person> list = Person.createRoster();
		list.forEach((p) -> System.out.println(p));

		// Now sort by age as anonymous class
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o2.getBirthday().compareTo(o1.getBirthday());
			}
		});

		// Sorted by age ascending 
		System.out.println("Sorted by age ascending [Anonumous Class]");
		list.forEach((p) -> System.out.println(p));

		/////////////////// Lambda //////////////////////////

		// Convert Comparator anonymous into lambda
		Collections.sort(list, (p1, p2) -> p1.getBirthday().compareTo(p2.getBirthday()));

		// Sorted by age descending
		System.out.println("Sorted by age descending [Lambda]");
		list.forEach((p) -> System.out.println(p));

		////////////////////// Lambda with existing method ///////////////////////////

		// The method to compare the birth dates of two Person instances already exists
		// as Person.compareByAge
		Collections.sort(list, (p1, p2) -> Person.compareByAge(p2, p1));

		// Sorted by age ascending
		System.out.println("Sorted by age ascending [Lambda existing method]");
		list.forEach((p) -> System.out.println(p));
		
		///////////////////// Method references ////////////////////////////
		
		Collections.sort(list, Person::compareByAge);

		// Sorted by age descending
		System.out.println("Sorted by age descending [Method references]");
		list.forEach((p) -> System.out.println(p));
		

	}

}
