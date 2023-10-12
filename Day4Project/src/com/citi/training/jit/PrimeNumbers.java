package com.citi.training.jit;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
	private List<Integer> primes;
	
	private boolean isPrime(int n) {
		for(int i=2; i < n; i++) {
			if(n%i == 0) {
				return false;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	private int getNextPrimeAbove(int previous) {
		int testNumber = previous + 1;
		while(!isPrime(testNumber)) {
			testNumber++;
		}
		return testNumber;
	}
	
	public void generateNumbers(int max) {
		primes = new ArrayList<>();
		primes.add(2);
		int next = 2;
		while(primes.size() <= max) {
			next = getNextPrimeAbove(next);
			primes.add(next);
		}
		System.out.println(primes);
	}
}
