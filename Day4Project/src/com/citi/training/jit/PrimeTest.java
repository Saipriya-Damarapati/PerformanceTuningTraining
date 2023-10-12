package com.citi.training.jit;

public class PrimeTest {

	public static void main(String[] args) {
		int max = Integer.parseInt(args[0]);
		PrimeNumbers p = new PrimeNumbers();
		p.generateNumbers(max);
	}

}
