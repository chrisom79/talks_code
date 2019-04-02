package com.java.reactiveprogramming;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
	int contador = 0;
	
	
	public MyCallable(int contador) {
		super();
		this.contador = contador;
	}


	@Override
    public Integer call() throws Exception {
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
	}
}

