package com.citi.training;

public class GCTest1 {

	public static void main(String[] args) {
		// create sample1 as reference variable and create object Sample(10)
		Sample sample1 = new Sample(10); 
		// both sample1 and sample2 references point to same object Sample(10)
		Sample sample2 = sample1;
		// sample1 doesn't point to any object -- still sample2 points to the object Sample(10)
		sample1 = null;
		//create sample3 as reference variable and create object Sample(20)
		Sample sample3 = new Sample(20);
		// both sample2 and sample3 are referring to Sample(20); 
		// at this point Sample(10) is eligible for garbage collection
		sample2 = sample3;
		// sample3 also will refer to null; so sample1 and sample3 do not refer any Objects
		sample3 = sample1;
		// sample2 refers to Sample(30), Sample(20) is not referred by any object
		// at this point Sample(20) is eligible for garbage collection
		sample2 = new Sample(30);
		// now Sample(30) is also garbage collected
		sample2 = null;
		/**
		 * When an object is garbage collected; finalize() method in Object class is automatically invoked
		 * the method is overridden there
		 */
		System.gc(); // manually trigerring gc -- this is not a guarnateed behaviour this method may or may not trigger when it is written as part of our code
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
