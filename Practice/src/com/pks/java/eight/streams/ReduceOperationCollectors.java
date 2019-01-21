package com.pks.java.eight.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pks.java.eight.lambda.Person;

public class ReduceOperationCollectors {

	public static void main(String[] args) {
		
		List<Person> list = Person.createRoster();
		
		
		// Example 1 Collectors.joining
		
		String names = list.stream()
			.filter(p -> p.getAge() > 20)
			.map(p -> p.getName())
			.collect(Collectors.joining(", "));
		
		System.out.println(names); // Jacob, Mia
		
		// Example 2 Collectors.toList()
		
		List<String> names1 = list.stream()
			.filter(p -> p.getAge() > 20)
			.map(p -> p.getName())
			.collect(Collectors.toList());
			
		System.out.println(names1); // [Jacob, Mia]
		
		// Example 3 Collectors.groupingBy
		
		Map<Integer, List<Person>> names2 = list.stream()
			.filter(p -> p.getAge() > 20)
			.collect(Collectors.groupingBy(p -> p.getAge() ));
				
		System.out.println(names2); // {33=[Jacob 33], 43=[Mia 43]}
		
		// Example 4 Collectors.groupingBy with "Downstream" collectors
		
		Map<Integer, Long> names3 = list.stream()
			.filter(p -> p.getAge() > 20)
			.collect(Collectors.groupingBy(Person::getAge , Collectors.counting()));
						
		System.out.println(names3); // {33=1, 43=1}
		
		// Example 5 Collectors.groupingBy with "mapping" "Downstream" collector which collects in a List
		
		Map<Integer, List<String>> names4 = list.stream()
			.filter(p -> p.getAge() > 20)
			.collect(Collectors.groupingBy(Person::getAge , Collectors.mapping(Person::getName, Collectors.toList())));
								
		System.out.println(names4); // {33=[Jacob], 43=[Mia]}
	}

}
