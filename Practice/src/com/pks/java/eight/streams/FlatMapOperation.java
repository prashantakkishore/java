package com.pks.java.eight.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 1 - It takes function as argument with () and returns a stream
 * Function<? super T, ? extends Stream<? extends R>>
 *
 */
public class FlatMapOperation {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> list2 = Arrays.asList(2,4,6);
		List<Integer> list3 = Arrays.asList(3,5,7);
		
		List<List<Integer>> list = Arrays.asList(list1,list2,list3);
		
		Function<List<Integer>,Integer> listSizeFunction = List::size;
		
		list.stream()
				.map(listSizeFunction)
				.forEach(System.out::println); // 7 3 3 
		
		// What if we want to print all elements of Lists from 'list'
		
		Function<List<Integer>,Stream<Integer>> listPrintFunction = List::stream;
		
		list.stream()
				.map(listPrintFunction)
				.forEach(System.out::println); // java.util.stream.ReferencePipeline$Head@3d075dc0 ...
		
		// Use flatMap to flatten the Stream
		list.stream()
				.flatMap(listPrintFunction)
				.forEach(System.out::println); // Prints all numbers
		
		

	}

}
