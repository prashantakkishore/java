package com.pks.java.eight.lambda;

public class RunnableLambda {

	public static void main(String[] args) throws InterruptedException {

		// This can be replaced with Lambda because this has only 1 abstract method
//		Runnable runnable = new Runnable() {
//			@Override
//			public void run() {
//				for(int i = 0; i< 100; i++){
//					System.out.println(i);
//				}
//			}
//		};
		
		// Lambda of above anonymous class can be made by
		// 1 : Add method parameter Eg: Nothing here so blank ()
		// 2 : Add arrow syntax
		// 3 : For multi line statements add and end with { and }
		Runnable runnableLambda = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i);
			}
		};
		
		Thread t = new Thread(runnableLambda);
		t.start();
		t.join();
		System.out.println("Main thread finishing....");

	}

}
