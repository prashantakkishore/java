package com.pks.java.eight.lambda.fuctionalinterfaces;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Predicate;

import com.pks.java.eight.lambda.Person;
import com.pks.java.eight.lambda.Person.Sex;

public class Predicates {

	public static void main(String[] args) {
		
		Predicate<Person> isMale = p -> p.isMale();
		Person p1 = new Person("John", LocalDate.of(2001, Month.JULY, 4), Sex.MALE, "John@a.com");
		System.out.println(isMale.test(p1)); // true

	}

}
