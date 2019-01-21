package com.pks.java.eight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinalOperation {

	public static void main(String[] args) {

		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

		//stream.forEach(System.out::println);
		
		Predicate<String> predicate = p -> p.length() > 3;
		
		// Any operation that returns Stream is a "lazy" operation and just a declaration.
		// Below as "filter" operation returns Stream its a "lazy" operation.
		// "forEach" is a final operation so it starts processing of filter.
		
		stream
			.filter(predicate)
			.forEach(System.out::println);
		
		/**
		 ********** Lazy/ Intermediary VS final operation
		 */
		
		// This code doesn't do anything as "peek" and "filter" returns a Stream so its a "lazy" operation
		Stream<String> stream2 = Stream.of("one", "two", "three", "four", "five");
		List<String> list = new ArrayList<>();
		stream2
			.peek(System.out::println)
			.filter(p -> p.length() > 3)
			.peek(list::add); // if we change "peek" to "forEach" code works fine as 
		//"forEach" doesn't return a Stream and is a final operation
		
		System.out.println(list.size()); // 0
		
		

	}

}
