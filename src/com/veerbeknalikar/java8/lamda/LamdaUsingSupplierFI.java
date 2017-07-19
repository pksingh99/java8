package com.veerbeknalikar.java8.lamda;

import java.util.function.Supplier;

/**
 * @author vbeknalikar
 * Supplier Functional Interface takes no argument and returns a value
 */
public class LamdaUsingSupplierFI {
	public static void main(String[] args) {
		
		//Example 1 - return a string
		Supplier<String> supplier = () -> "This is a Supplier supplied string";
		System.out.println(supplier.get());

		//Example 2 - replace 'A' with 'B' in an input string and return the response
		String response = processAnsSupplyAString(() -> {
			//Process some logic - add two strings
			String str1 = "Hello ";
			String str2 = "World!";
			return str1.concat(str2);			
		});
		System.out.println(response);
	}

	private static String processAnsSupplyAString(Supplier<String> supplier) {
		return supplier.get();
	}
}
