package com.pks.java.eight.lambda.methodreferences.types;

import java.util.function.Function;
import java.util.function.Supplier;

import com.pks.java.eight.lambda.Person;

public class ConstructorMR {

	public static void main(String[] args) {
		Supplier<Person> personCreator = Person::new;
		// Here default constructor will be called 
		System.out.println(personCreator.get().getName()); // null

		Function<String, Person> nameParamPersonCreator = Person::new;
		// Here John will be passed as Constructor argument with name
		System.out.println(nameParamPersonCreator.apply("John").getName()); // John
		
	}
}
