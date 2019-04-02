package com.java.reactiveprogramming;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ReactiveV6 {
	static int  contador = 0;
	
	static Callable<Integer> callable = () -> {
		
		for(int i = 0;i < 5;i++) {
	        	contador++;
	            try {
	                Thread.sleep(1000);
	                System.out.println("Contador del hilo: " + Thread.currentThread().getName() + " total: " + contador);
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	             
		}         
	    
	    return contador;
		
	};
	
	public static void main(String[] args) {
		System.out.println("Iniciando...");
		
		ExecutorService servicio = Executors.newFixedThreadPool(2);
		 
        Future<Integer> resultado = servicio.submit(callable);
        Future<Integer> resultado2 = servicio.submit(callable);	
        
		
		System.out.println("Termino.");
	}
	
	
}

