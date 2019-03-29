package com.java.reactiveprogramming;

public class ReactiveV3_1 {
	private static final Object lock = new Object();
	
	static Thread  thread1 = new Thread(() -> {	
		int count = 0;
		
		synchronized(lock) {
			System.out.println("Running thread 1");
			while(count < 5) {
				try {
					Thread.sleep(1000);
					System.out.println("Alive: " + count++);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Termino.");
	}
}
