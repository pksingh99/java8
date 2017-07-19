package com.veerbeknalikar.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.veerbeknalikar.java8.Person;


/**
 * @author vbeknalikar
 *
 */
public class StreamExample {
	public static void main(String...args){
	  List<Person> people = Arrays.asList(
				new Person("Mark", "Taylor", 41),
				new Person("Alister", "Campbell", 36), 
				new Person("Jeff", "Crow", 27),
				new Person("Zoe", "Barns",18));
	  
		//Example1 - Usage of map - print firstnames
	    System.out.println("Example1 - Usage of map - print firstnames");
	  	people.stream().map(p -> p.getFirstName())
	  					.forEach(System.out::println);

		//Example2 - Usage of filter - print firstnames with age > 30
	    System.out.println("\nExample2 - Usage of filter - print firstnames with age > 30");
	  	people.stream().filter(p -> p.getAge() > 30)
	  				   .forEach(System.out::println);
	  
		//Example3 - Usage of sorted - print firstnames 
	    System.out.println("\nExample3 - Usage of sorted - print firstnames ");
	  	people.stream().map(p -> p.getFirstName())
	  				   .sorted()
	  				   .forEach(System.out::println);
	  	
		//Example4 - Usage of count - count persons with age > 20
	    System.out.println("\nExample3 - Usage of sorted - print firstnames ");
	    long count = people.stream().filter(p -> p.getAge() > 20)
	  				   .count();
	    System.out.println(count);
	  
		//Example5 - Usage of collect - count persons whose lastName starts with C
	    System.out.println("\nExample5 - Usage of collect - count persons whose lastName starts with C ");
	    List<Person> persons = people.stream().filter(p -> p.getLastName().startsWith("C"))
	  				   .collect(Collectors.toList());
	    persons.forEach(System.out::println);
	    
	  //Example6 - Usage of filter, map, sorted with comparator, forEach - print firstnames
	    System.out.println("\nExample6 - Usage of filter, map, sorted with comparator, forEach - print persons ");
	    people.stream().filter(p -> p.getAge()>10)
						.map(p -> p.getFirstName().concat(" VB") )
						.map(p -> p.replace(" VB", "") )
						.sorted((p1, p2) -> p2.compareTo(p1))
						.forEach(p -> System.out.println(p));
		
		//Example7 - Usage of parrallelStream, filter, map, sorted with comparator, forEach - print firstnames
	    System.out.println("\nExample7 - Usage of parrallelStream, filter, map, sorted with comparator, forEach - print persons ");
	    people.parallelStream().filter(p -> p.getAge()>10)
						.map(p -> p.getFirstName().concat(" VB") )
						.map(p -> p.replace(" VB", "") )
						.sorted((p1, p2) -> p2.compareTo(p1))
						.forEach(p -> System.out.println(p));
	    
	}
}
