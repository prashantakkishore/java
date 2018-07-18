package com.pks.ds.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/**
 * O(n2)
 *
 */
public class ThreeSum {
	static class Triplet {
		int x, y, z;

		public Triplet(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int hashCode() {
			// Depends on sequence too eg: [1,2,3] hash is differnt than [1,3,2]
			return Objects.hash(x, y, z);
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Triplet) {
				Set<Integer> numbers = new HashSet<>();
				numbers.addAll(new ArrayList<>(Arrays.asList(x, y, z)));

				Triplet other = (Triplet) o;
				return numbers.containsAll(new ArrayList<>(Arrays.asList(
						other.x, other.y, other.z)));
			}

			return false;
		}
	}

	public static Set<Triplet> findTriplets(int numbers[], int targetSum) {
		Set<Triplet> triplets = new HashSet<>();

		// insert all pairs in the look up table
		Map<Integer, int[]> lookup = new HashMap<>();
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int total = numbers[i] + numbers[j];
				lookup.put(total, new int[] { i, j });
			}
		}

		// look for the complement, if found viola! here you go with the
		// matching triplet
		for (int number : numbers) {
			int complement = targetSum - number;

			if (lookup.containsKey(complement)) {
				int indexes[] = lookup.get(complement);
				int x = numbers[indexes[0]], y = numbers[indexes[1]];
				triplets.add(new Triplet(x, y, number));
			}
		}

		return triplets;
	}

	public static void main(String[] args) {
		int numbers[] = { 12, 3, 4, 1, 6, 9 };

		System.out.print(ThreeSum.findTriplets(numbers, 24));

		for (ThreeSum.Triplet triplet : ThreeSum.findTriplets(numbers, 24)) {
			System.out.println(triplet.x + ", " + triplet.y + ", " + triplet.z);
		}

		// can handle duplicate?
		System.out.println("==============================");
		numbers = new int[] { 12, 3, 4, 1, 6, 9, 9, 9, 9, 9 };

		System.out.print(ThreeSum.findTriplets(numbers, 24));

		for (ThreeSum.Triplet triplet : ThreeSum.findTriplets(numbers, 24)) {
			System.out.println(triplet.x + ", " + triplet.y + ", " + triplet.z);
		}
	}
}
