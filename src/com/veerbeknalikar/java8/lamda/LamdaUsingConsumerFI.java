package com.veerbeknalikar.java8.lamda;

import java.util.function.Consumer;

/**
 * @author vbeknalikar
 * Consumer Functional Interface accepts one argument with no return value
 */
public class LamdaUsingConsumerFI {
	public static void main(String[] args) {
		
		removeEmptySpaces("This Is A Test String", str -> {
			str = str.replaceAll(" ","");
			System.out.println(str);
		});

	}

	private static void removeEmptySpaces(String str, Consumer<String> consumer) {
		consumer.accept(str);	
	}
}
