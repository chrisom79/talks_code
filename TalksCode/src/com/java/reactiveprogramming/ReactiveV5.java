package com.java.reactiveprogramming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;

public class ReactiveV5 {
	private static final Lock lock = new ReentrantLock();
	static int count = 0;
	
	public static Function<Integer, Thread> hilo = count -> {
		
		return new Thread(() -> increment());
	};
	
	public static void increment() {
		int internal = 0;
		lock.lock();
		System.out.println("Running thread "+Thread.currentThread().getName());
		try {
			while(internal < 10) {
				Thread.sleep(1000);
				System.out.println("Alive #: "+Thread.currentThread().getName()+" "+Thread.currentThread().hashCode()+" "+count++);
				if(count % 10 == 0) {
					System.out.println("Trying sleep "+Thread.currentThread().getName());
					Thread.sleep(5000);
				}
				internal++;
			}
		} catch (InterruptedException e) {
			System.out.println("NOT sleep  "+Thread.currentThread().getName()+" "+Thread.currentThread().hashCode()+" "+count++);
				e.printStackTrace();
		} finally {
			lock.unlock();
		};
	}
	
	public static void main(String[] args) {
		System.out.println("Iniciando...");
		
		try {
			while(count < 100) {
				Thread t1 = ReactiveV5.hilo.apply(count);
				t1.setName("t1");
				Thread t2 = ReactiveV5.hilo.apply(count);
				t2.setName("t2");
				Thread t3 = ReactiveV5.hilo.apply(count);
				t3.setName("t3");
				Thread t4 = ReactiveV5.hilo.apply(count);
				t4.setName("t4");
				
				t4.start();
				t1.start();
				t3.start();
				t2.start();
				
				
				
				t1.join();
				t2.join();
				t3.join();
				t4.join();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Termino.");
	}
}
