package com.java.reactiveprogramming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReactiveV5 {
	private static final Lock lock = new ReentrantLock();
	static int count = 0;
	static Thread  thread1 = new Thread(() -> {	
		int internal = 0;
		lock.lock();
		System.out.println("Running thread 1");
		try {
			while(internal < 10) {
				Thread.sleep(1000);
				System.out.println("Alive #1: " + count++);
				if(count % 10 == 0) {
					System.out.println("Trying sleep thread 1");
					Thread.sleep(5000);
				}
				internal++;
			}
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	});
	
	static Thread  thread2 = new Thread(() -> {
		int internal = 0;
		lock.lock();
		System.out.println("Running thread 2");
		try {
			while(internal < 10) {
				Thread.sleep(1000);
				System.out.println("Alive #2: " + count++);
				if(count % 10 == 0) {
					System.out.println("Trying sleep thread 2");
					Thread.sleep(5000);
				}
				internal++;
			}
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} finally {
			lock.unlock();
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
