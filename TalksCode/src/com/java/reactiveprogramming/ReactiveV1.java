package com.java.reactiveprogramming;

public class ReactiveV1 {
	public static Boolean flag;
	
	static Thread  thread1 = new Thread(() -> {System.out.println("Running thread 1");});
	static Thread  thread2 = new Thread(() -> {System.out.println("Running thread 2");});
	
	public static void main(String[] args) {
		System.out.println("Iniciando...");
		thread1.start();
		thread2.start();
		System.out.println("Terminando...");
	}

}
