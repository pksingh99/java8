package com.veerbeknalikar.java8.lamda;

import java.util.function.Function;

/**
 * @author vbeknalikar
 * Consumer Functional Interface accepts one argument and returns a value
 */
public class LamdaUsingFunctionFI {
	public static void main(String[] args) {
		
		//Example 1 - return the input string as is
		Function<String, String> function = str -> str;
		System.out.println(function.apply("Return this string!"));

		//Example 2 - replace 'A' with 'B' in an input string and return the response
		String response =replaceAwithB("This is A Test String", str1 -> str1.replaceAll("A", "B"));
		System.out.println(response);
	}

	private static String replaceAwithB(String str, Function<String, String> function){
		return function.apply(str);
		
	}
}
