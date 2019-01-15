package com.pks.java.eight.lambda.fuctionalinterfaces;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Function;

import com.pks.java.eight.lambda.Person;
import com.pks.java.eight.lambda.Person.Sex;

public class Functions {

	public static void main(String[] args) {
		
		Function<Person, LocalDate> birthday = p -> p.getBirthday();
		Person p1 = new Person("John", LocalDate.of(2001, Month.JULY, 4), Sex.MALE, "John@a.com");
		System.out.println(birthday.apply(p1)); // 2001-07-04

	}

}
