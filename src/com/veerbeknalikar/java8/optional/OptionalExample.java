package com.veerbeknalikar.java8.optional;

import java.util.Optional;

import com.veerbeknalikar.java8.Person;


/**
 * @author vbeknalikar
 *
 */
public class OptionalExample {
	public static void main(String...args){

		//Example1 - isPresent()
		System.out.println("Example1 - isPresent()");
		Optional<Person> optPerson = Optional.empty(); 
		System.out.println(optPerson.isPresent());

		//Example2 - of()
		System.out.println("\nExample2 - of()");
		Optional<Person> optPerson2 = Optional.of(new Person("John","Doe",30));
		optPerson2.ifPresent(p -> System.out.println(p));	
		
		//Example3 - orElse()
		System.out.println("\nExample3 - orElse()");
		Optional<Person> optPerson3 = Optional.empty(); 
		Person person3 = optPerson3.orElse(new Person("John","Doe",30));
		System.out.println(person3);
		
	}
}
