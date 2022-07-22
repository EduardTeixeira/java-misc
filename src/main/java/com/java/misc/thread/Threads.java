package com.java.misc.thread;

public class Threads {

	static int i = 0;

	public static void main(String[] args) throws InterruptedException {
		new Thread(t1).start();
		new Thread(t2).start();
		
	    System.out.println("Start main thread.");

	    Thread firstThread = new Thread(() -> {
	        System.out.println("First thread is running.");
	    });

	    Thread secondThread = new Thread(() -> {
	        System.out.println("Second thread is running.");
	    });

	    secondThread.start();
	    firstThread.start();
	    
	    System.out.println("@@@ Entre as threads @@@");

	    
	    for (int i = 0; i < 20; i++) {
	    	System.out.println("AAA" + i);
	    }
	    
	    firstThread.join();
	    
	    
	    secondThread.join();
	    
	    for (int i = 0; i < 20; i++) {
	    	System.out.println("BBB" + i);
	    }
	    	    
	    System.out.println("Entre as threads");

	    System.out.println("End main thread.");
	    
	}

	private static void countMe(String name) {
		i++;
		System.out.println("Current Counter is: " + i + ", updated by: " + name);
	}

	private static Runnable t1 = new Runnable() {
		public void run() {
			try {
				for (int i = 0; i < 5; i++) {
					countMe("t1");
				}
			} catch (Exception e) {
			}

		}
	};

	private static Runnable t2 = new Runnable() {
		public void run() {
			try {
				for (int i = 0; i < 5; i++) {
					countMe("t2");
				}
			} catch (Exception e) {
			}
		}
	};

}
