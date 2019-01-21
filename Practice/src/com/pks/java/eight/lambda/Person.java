package com.pks.java.eight.lambda;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}
	
	public  Person() {
		
	}
	
	public  Person(String name) {
		this.name = name;
	}

	public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public int getAge() {
		return birthday.until(LocalDate.now()).getYears();
	}
	public String getName() {
		return name;
	}

	public void printEmail() {
		System.out.println("You registered as : " + this.emailAddress);
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}
	
	public int compareByName(Person a, Person b) {
		return a.name.compareTo(b.name);
	}
	
	public int compareByNameParam(Person b) {
		return this.name.compareTo(b.name);
	}
	
	public static boolean isAgeMoreThan25(Person person) {
		return person.getAge() > 25;
	}
	
	public boolean isAgeMoreThan30(Person person) {
		return person.getAge() > 30;
	}
	
	public boolean isMale() {
		return this.gender == Sex.MALE;
	}
	
	
	public static List<Person> createRoster(){
		Person p1 = new Person("John", LocalDate.of(2001, Month.JULY, 4), Sex.MALE, "John@a.com");
		Person p2 = new Person("Jacob", LocalDate.of(1985, Month.JULY, 4), Sex.MALE, "Jacob@a.com");
		Person p3 = new Person("Sophia", LocalDate.of(2011, Month.JULY, 4), Sex.FEMALE, "Sophia@a.com");
		Person p4 = new Person("Mia", LocalDate.of(1975, Month.JULY, 4), Sex.FEMALE, "Mia@a.com");
		Person p5 = new Person("Lucas", LocalDate.of(2001, Month.JULY, 4), Sex.MALE, "Lucas@a.com");
		Person p6 = new Person("Aria", LocalDate.of(2007, Month.JULY, 4), Sex.FEMALE, "Aria@a.com");
		Person p7 = new Person("Luke", LocalDate.of(2001, Month.JULY, 4), Sex.MALE, "Luke@a.com");
		Person p8 = new Person("Lily", LocalDate.of(2007, Month.JULY, 4), Sex.FEMALE, "Lily@a.com");
		
		return Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName() + " " + this.getAge();
	}
}
