package com.veerbeknalikar.java8.lamda;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author vbeknalikar
 * 
 */
public class LamdaUsingMethodReference {
	public static void main(String...args) {
		//Example1 - convert a string to lowercase
		System.out.format("%s", formatString("Test String", String::toLowerCase));
		
		//Example2 - create a string and return
		System.out.format("\n%s", formatString("Create this String", String::new));
		
		//Example3 - get substring starting from an supplied input position
		System.out.format("\n%s", formatString("This is a string", 10, String::substring));
		
		//Example3 - Use of Instance Method Reference - concat two strings
		String str1 = "String1 ";
		System.out.format("\n%s", formatString("String2",str1::concat));
	}
	
	public static String formatString(String str, Function<String, String> processor) {
		return processor.apply(str);
	}
	public static String formatString(String str, Integer i, BiFunction<String, Integer, String> processor) {
		return processor.apply(str, i);
	}
}
