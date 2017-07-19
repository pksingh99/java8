package com.veerbeknalikar.java8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



/**
 * @author vbeknalikar
 *  
 */
public class ExecuterServiceThreadPoolExample {

	public static void main(String[] args) {
		ExecutorService excutor = Executors.newFixedThreadPool(3);
		for(int i=0;i<10;i++) {
			excutor.submit(new Processor(i));
		}

		excutor.shutdown();
		System.out.println("All jobs submitted.");
		try {
			excutor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All jobs completed.");
	}
}


class Processor implements Runnable {

	int i;
	public Processor(int i) {
		this.i = i;
	}

	@Override
	public void run() {

		System.out.println("Starting "+i);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Completing "+i);
	}

}
