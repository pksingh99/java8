package com.veerbeknalikar.java8.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.veerbeknalikar.java8.Person;

public class LamdaUsingPredicateFIAndConsumerFI {
	static List<Person> people = Arrays.asList(
			new Person("Mark", "Taylor", 41),
			new Person("Alister", "Campbell", 36), 
			new Person("Jeff", "Crow", 27),
			new Person("Zoe", "Barns",18));

	public static void main(String[] args) {

		// 1. Sort by lastname
		Collections.sort(people, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));

		// 2.Print all persons
		performConditionally(people, p -> true, p -> System.out.println(p));

		// 3.Print all persons start with A
		performConditionally(people, p -> p.getFirstName().startsWith("A"), p -> System.out.println(p.getFirstName()));
	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		for (Person p : people) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}

		}
	}
}
