package com.pks.java.eight.streams;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import com.pks.java.eight.lambda.Person;

/**
 * 1 - Reduce operation takes two argument of same type and returns one of same type
 * 2 - It is an "Final"/ "Terminal" operation
 * 3 - It takes special kind of "BiFunction" named "BinaryOperator" as argument. BiFunction<T,T,T>
 * 4 - Its of 2 types , aggregation and collectors
 * 5 - max(), min(), count() returns objects
 * 6 - allMatch(), noneMatch(), anyMatch() returns booleans
 * 7 - findFirst(), findAny() returns 'Options'
 *
 */
public class ReduceOperation {

	public static void main(String[] args) {
		List<Person> list = Person.createRoster();

		Integer i = list.stream()
				.map(p -> p.getAge()) // As we need total of all ages, map to get all ages
				.reduce(0, (a1, a2) -> a1 + a2); // now its of type BiFunction<T,T,T> as takes 2 integers and returns
													// Integer
		// 0 is a identity element
		System.out.println(i);

		///// Identity examples

		// Example 1
		Stream<Integer> nums = Stream.of(1);
		Integer total = nums.reduce(0, (num1 , num2) -> num1 + num2);
		System.out.println(total); // 1

		// Example 2
		Stream<Integer> nums1 = Stream.of(1, 2, 3, 4, 5);
		BinaryOperator<Integer> maxOpr = (num1, num2) -> num1 > num2 ? num1 : num2;
		Integer max = nums1.reduce(0, maxOpr);
		System.out.println(max); // 5

		// Example 3
		Stream<Integer> nums2 = Stream.of(-5,-10);
		BinaryOperator<Integer> maxOpr1 = (num1, num2) -> num1 > num2 ? num1 : num2;
		Integer max1 = nums2.reduce(0, maxOpr1);
		System.out.println(max1); // 0 Which is "not correct" this should be -5. So now we dont know what should be identity.

		// Example 4 - Optionals
		Stream<Integer> nums3 = Stream.of(-5,-10);
		BinaryOperator<Integer> maxOpr2 = (num1, num2) -> num1 > num2 ? num1 : num2;
		Optional<Integer> maxVal = nums3.reduce(maxOpr2);
		System.out.println(maxVal.get()); //-5

	}

}
