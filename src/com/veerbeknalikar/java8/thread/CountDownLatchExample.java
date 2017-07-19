package com.veerbeknalikar.java8.thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author vbeknalikar
 *
 */
public class CountDownLatchExample {
	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);

		List<Thread> workers = Stream
			      .generate(() -> new Thread(new CountDownLatchProcessor(latch)))
			      .limit(3)
			      .collect(Collectors.toList());
		
		workers.forEach(Thread::start);
		
		System.out.println("All jobs submitted.");
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("All jobs completed.");
	}
}


 class CountDownLatchProcessor implements Runnable {

	CountDownLatch latch;

	public CountDownLatchProcessor(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		System.out.println("Starting ");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("Latch count down ");

	}

}
