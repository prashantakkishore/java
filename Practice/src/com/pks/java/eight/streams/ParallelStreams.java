package com.pks.java.eight.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.pks.java.eight.lambda.Person;

/**
 * Good read : https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html
 * 1 - Parallelism is not automatically faster than performing operations serially, although it can be 
 * 		if you have enough data and processor cores
 * 
 * 2 - When a stream executes in parallel, the Java runtime partitions the stream into multiple substreams. 
 * 		Aggregate operations iterate over and process these substreams in parallel and then combine the results.
 * 
 * 3 - When you create a stream, it is always a serial stream unless otherwise specified. To create a parallel stream, 
 * 		invoke the operation "Collection.parallelStream". Alternatively, invoke the operation "BaseStream.parallel"
 */
public class ParallelStreams {

	public static void main(String[] args) {

		// Example 1
		
		List<Person> list = Person.createRoster();
		double average = list
			    .parallelStream() // Parallel Stream
			    .filter(p -> p.getGender() == Person.Sex.MALE)
			    .mapToInt(Person::getAge)
			    .average()
			    .getAsDouble();
		System.out.println(average); // 21.0
		
		// Example 2 Concurrent Reduction
		
		Map<Person.Sex, List<Person>> byGender =
				list.stream()
			        .collect(Collectors.groupingBy(Person::getGender));
		System.out.println(byGender); // {FEMALE=[Sophia 7, Mia 43, Aria 11, Lily 11], MALE=[John 17, Jacob 33, Lucas 17, Luke 17]}
		
		// parallel equivalent
		// Some things to note here
		// 1 - Instead of "groupingBy" we used "groupingByConcurrent" as multiple threads will run on collections we need concurrent collections
		// 2 - Returns "ConcurrentMap" instead of "Map" as compared to Serial stream above.
		ConcurrentMap<Person.Sex, List<Person>> byGender1 =
				list.parallelStream()
			        .collect(Collectors.groupingByConcurrent(Person::getGender));
		System.out.println(byGender1); // {FEMALE=[Sophia 7, Mia 43, Aria 11, Lily 11], MALE=[John 17, Jacob 33, Lucas 17, Luke 17]}
		
		// Example 3 Ordering
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		nums.stream()
			.forEach(e -> System.out.print(e + " ")); // 1 2 3 4 5 6 7 8 9 
		System.out.println("");
		
		nums.parallelStream()
			.forEach(e -> System.out.print(e + " ")); // 6 5 4 2 8 1 3 7 9 [Unpredictable]
		System.out.println("");
		
		// Note that you may lose the benefits of parallelism if you use operations like forEachOrdered with parallel streams.
		// processes the elements of the stream in the order specified by its source, regardless of whether you executed the 
		// stream in serial or parallel
		nums.parallelStream()
			.forEachOrdered(e -> System.out.print(e + " ")); // 1 2 3 4 5 6 7 8 9 
		
		

	}

}
