package com.veerbeknalikar.java8.lamda.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.veerbeknalikar.java8.lamda.LamdaUsingMethodReference;
public class LamdaUsingMethodReferenceTest {
	LamdaUsingMethodReference lamdaUsingMethodReference = new LamdaUsingMethodReference();
	@Test
	public void testConvertToLowerCase() {
		assertEquals("test string", lamdaUsingMethodReference.formatString("Test String", String::toLowerCase));
	}

	@Test
	public void testCreateAStringAndReturn() {
		assertEquals("Create this String", lamdaUsingMethodReference.formatString("Create this String", String::new));
	}
	
	@Test
	public void testConcatinateStrings() {
		String str1 = "String1 ";
		assertEquals("String1 String2", lamdaUsingMethodReference.formatString("String2",str1::concat));
	}
	
	@Test
	public void testSubstring() {
		assertEquals("string", lamdaUsingMethodReference.formatString("This is a string", 10, String::substring));
	}
}
