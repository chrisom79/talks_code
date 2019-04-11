package com.java.reactiveprogramming;

public class ReactiveV3 {
	private static final Object lock = new Object();
	
	static Thread  thread1 = new Thread(() -> {	
		int count = 0;
		
		synchronized(lock) {
			System.out.println("Running thread 1");
			try {
				Thread.sleep(3000);
				while(count < 5) {
						Thread.sleep(1000);
						System.out.println("Counting: " + count++);	
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.notifyAll();
		}
		
	});
	
	static Thread  thread2 = new Thread(() -> {
		synchronized(lock) {
			System.out.println("Running thread 2");
		}
	});
	
	public static void main(String[] args) {
		System.out.println("Iniciando...");
		
		try {
			thread1.start();
			thread2.start();
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Termino.");
	}
}
