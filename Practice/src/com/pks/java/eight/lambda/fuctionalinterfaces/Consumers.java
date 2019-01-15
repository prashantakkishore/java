package com.pks.java.eight.lambda.fuctionalinterfaces;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Consumer;

import com.pks.java.eight.lambda.Person;
import com.pks.java.eight.lambda.Person.Sex;

public class Consumers {

	public static void main(String[] args) {
		
		Consumer<Person> printEmail = e -> e.printEmail();
		Person p1 = new Person("John", LocalDate.of(2001, Month.JULY, 4), Sex.MALE, "John@a.com");
		printEmail.accept(p1); // You registered as : John@a.com
 
	}

}
