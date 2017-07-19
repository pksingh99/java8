package com.veerbeknalikar.java8.lamda;

import java.util.function.BiPredicate;

/**
 * @author vbeknalikar
 * BiPredicate Functional Interface accepts two arguments and returns a boolean
 */
public class LamdaUsingBiPredicateFI {

	public static void main(String[] args) {

		//3 is not a factor of 10
		isSecondNumberFactorOfFirstNumber(10, 3, (n1, n2) -> (n1 % n2 == 0));
		
		//5 is  a factor of 20
		isSecondNumberFactorOfFirstNumber(20, 5, (n1, n2) -> (n1 % n2 == 0));

		//3 is  a factor of 12
		isSecondNumberFactorOfFirstNumber(12, 3, (n1, n2) -> (n1 % n2 == 0));

	}

	private static void isSecondNumberFactorOfFirstNumber(Integer n1, Integer n2, BiPredicate<Integer,Integer> biPredicate) {
		if (biPredicate.test(n1, n2)) {
			System.out.format("\n%d is a factor of %d", n2, n1);
		}
		else {
			System.out.format("\n%d is NOT a factor of %d", n2, n1);
		}
	
	}

}
