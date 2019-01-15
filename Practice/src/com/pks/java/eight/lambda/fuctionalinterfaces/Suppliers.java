package com.pks.java.eight.lambda.fuctionalinterfaces;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Supplier;

import com.pks.java.eight.lambda.Person;
import com.pks.java.eight.lambda.Person.Sex;

public class Suppliers {

	public static void main(String[] args) {
		
		Supplier<Person> newPerson = () -> new Person("John", LocalDate.of(2001, Month.JULY, 4), Sex.MALE, "John@a.com");
		System.out.println(newPerson.get().getName()); // John

	}

}
