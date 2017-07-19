package com.veerbeknalikar.java8.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author vbeknalikar
 * Predicate Functional Interface accepts one argument and returns a boolean value
 */
public class LamdaUsingPredicateFI {
	public static void main(String...args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//Print all numbers
		System.out.println("Printing all numbers:");
		print(numbers, n -> true);
		
		//Print even numbers
		System.out.println("Printing even numbers:");
		print(numbers, n -> n % 2 == 0);
		
		//Print odd numbers
		System.out.println("Printing odd numbers:");
		print(numbers, n -> !(n % 2 == 0));
		
		//Print numbers greater than 4 and less than 8
		System.out.println("Printing numbers greater than 4 and less than 8:");
		print(numbers, n -> (n > 4) && (n < 8));
	}
	
	private static void print(List<Integer> numbers, Predicate<Integer> predicate ) {
		for(Integer n : numbers) {
			if (predicate.test(n)) {
				System.out.println(n);
			}
		}
		
	}
}
