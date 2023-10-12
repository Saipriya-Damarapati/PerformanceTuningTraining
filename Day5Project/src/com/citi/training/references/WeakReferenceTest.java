package com.citi.training.references;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		X x1=new X(30);
		WeakReference<X> weakReference=new WeakReference<X>(x1);
		if(weakReference.get()!=null) {
			System.out.println(weakReference.get());
		}
		else {
			System.out.println("object not available");
		}
		x1=null;
		for(int i=1;i<=20;i++) {
			System.gc();
		}
		if(weakReference.get()!=null) {
			System.out.println(weakReference.get());
		}
		else {
			System.out.println("object not available");
		}

	}

}
