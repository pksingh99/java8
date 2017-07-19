package com.veerbeknalikar.java8.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 * @author vbeknalikar
 *
 */
public class MultipleLocksSynchronisedBlocksExample {

	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();

	Object lock1 = new Object();
	Object lock2 = new Object();
	

	public synchronized void processListOne() {

		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			list1.add(new Random().nextInt(100));			
		}
	}

	public synchronized void processListTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			list2.add(new Random().nextInt(100));
		}	
	}

	public void process() {
		for (int i=0; i<1000; i++) {	
			processListOne();
			processListTwo();
		}
	}
	public static void main(String...args) {
		MultipleLocksSynchronisedBlocksExample app =  new MultipleLocksSynchronisedBlocksExample();
		System.out.println("starting..");
		long startTime = System.currentTimeMillis();
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				app.process();
			}
			
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				app.process();
			}
			
		});
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			((Thread)thread2).join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("Completed..");
		System.out.println("Time taken:" + (endTime-startTime + "; list1:"+app.list1.size() + "; list2:"+app.list2.size()));
		
		
	}
}

