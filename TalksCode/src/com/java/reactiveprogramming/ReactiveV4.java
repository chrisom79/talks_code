package com.java.reactiveprogramming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReactiveV4 {
	private static final Lock lock = new ReentrantLock();
	
	static Thread  thread1 = new Thread(() -> {	
		int count = 0;
		System.out.println("Running thread 1");
		lock.lock();
			
		while(count < 5) {
			try {
				Thread.sleep(1000);
				System.out.println("Alive: " + count++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		lock.unlock();
		
	});
	
	static Thread  thread2 = new Thread(() -> {
		lock.lock();
		System.out.println("Running thread 2");
		lock.unlock();
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
