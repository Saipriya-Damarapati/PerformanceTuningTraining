package com.citi.training.references;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		X x1=new X(30);
		SoftReference<X> softReference=new SoftReference<X>(x1);
		if(softReference.get()!=null) {
			System.out.println(softReference.get());
		}
		else {
			System.out.println("object not available");
		}
		x1=null;
		for(int i=1;i<=20;i++) {
			System.gc();
		}
		if(softReference.get()!=null) {
			System.out.println(softReference.get());
		}
		else {
			System.out.println("object not available");
		}

	}

}
