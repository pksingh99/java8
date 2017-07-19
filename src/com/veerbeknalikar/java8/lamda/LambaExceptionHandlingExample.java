package com.veerbeknalikar.java8.lamda;

import java.util.function.BiConsumer;

public class LambaExceptionHandlingExample {
	public static void main(String... args) {
		int[] numbers = {1,2,3,4};
		//Example1 - With Exceptions
		int key = 0;
		processNumbers(numbers, key, wrapperLamda((v,k) -> System.out.println(v/k)));
													
		
		//Example2 - Without Exceptions
		key =1;
		processNumbers(numbers, key, wrapperLamda((v,k) -> System.out.println(v/k)));
	}
	
	private static void processNumbers(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
		for(int n : numbers) {
			consumer.accept(n, key);
		}
	}
	private static BiConsumer<Integer, Integer> wrapperLamda(BiConsumer<Integer, Integer> consumer) {
		return (v,k) -> {
			try {
				System.out.println("Exceuting within wrapperLamda");
				System.out.println(v/k);
			}catch(ArithmeticException e) {
				System.out.println("ArithmeticException thrown");
			}
		};
	}
}
