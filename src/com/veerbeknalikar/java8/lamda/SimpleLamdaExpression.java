package com.veerbeknalikar.java8.lamda;

/**
 * @author vbeknalikar
 * Simple lamda expression with a FunctionInterface
 */
public class SimpleLamdaExpression {

	public static void main(String...args) {
		String testString = "Test String";
		System.out.format("%s", formatString(testString, str -> str.toLowerCase()));
	}
	
	private static String formatString(String str, StringProcessor processor) {
		return processor.formatString(str);
	}

	@FunctionalInterface
	interface StringProcessor {
		String formatString(String str);
	}
}
