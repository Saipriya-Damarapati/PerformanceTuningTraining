package com.citi.training.deadlock;

public class TestMain {
	
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		Thread1 t1 = new Thread1(a, b);
		t1.setName("First Thread");
		Thread2 t2 = new Thread2(a, b);
		t2.setName("Second Thread");
		t1.start();
		t2.start();
	}

}
