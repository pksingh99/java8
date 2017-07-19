package com.veerbeknalikar.java8.thread;



/**
 * @author vbeknalikar
 *
 */
public class SynchronisedMethodExample {

	int count;

	public synchronized void incrementCount() {
		count++;
	}

	public void doWork() {
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					incrementCount();
				}
			}

		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					incrementCount();
				}

			}

		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Count is:" + count);

	}

	public static void main(String... args) {
		SynchronisedMethodExample app = new SynchronisedMethodExample();
		app.doWork();
	}

}

