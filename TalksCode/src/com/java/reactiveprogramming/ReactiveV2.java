package com.java.reactiveprogramming;

public class ReactiveV2 {
public static Boolean flag = Boolean.FALSE;
	
	static Thread  thread1 = new Thread(() -> {	
		int count = 0;
		System.out.println("Running thread 1");
		flag = Boolean.TRUE;
		while(flag) {
			try {
				Thread.sleep(1000);
				System.out.println("Alive: " + count++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	static Thread  thread2 = new Thread(() -> {
		flag = Boolean.FALSE;
		if(!flag) {
			System.out.println("Running thread 2");
		}
		});
	
	public static void main(String[] args) {
		System.out.println("Iniciando...");
		
		try {
			thread1.start();
			System.out.println("1. Flag: " + flag);
			thread1.sleep(5000);
			thread2.start();
			System.out.println("2. Flag: " + flag);
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Termino.");
	}
}
