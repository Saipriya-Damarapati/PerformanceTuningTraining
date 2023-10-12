package com.citi.training.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

class Counter{
	static int count=0;
}

class P{
	P()
	{
		Counter.count++;
	}
}

class ClearReference extends PhantomReference<P>{

	public ClearReference(P referent, ReferenceQueue<? super P> q) {
		super(referent, q);
		// TODO Auto-generated constructor stub
	}
	
	void cleanUp()
	{
		Counter.count--;
	}
	
}


class CleanUpThread extends Thread{
	private ReferenceQueue<P> referenceQueue;

	public CleanUpThread(ReferenceQueue<P> referenceQueue) {
		super();
		this.referenceQueue = referenceQueue;
	}
	
	public void run()
	{
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			ClearReference ref=(ClearReference)referenceQueue.poll();
			if(ref!=null) {
				ref.cleanUp();
			}
		}
	}
}
public class PhantomReferenceTest {
public static void main(String[] args) {
	P p1=new P();
	ReferenceQueue<P> queue=new ReferenceQueue<P>();
	ClearReference ref=new ClearReference(p1, queue);
	
	System.out.println("Count:"+Counter.count);
	p1=null;
	CleanUpThread thread=new CleanUpThread(queue);
	thread.start();
	for(int i=1;i<=20;i++) {
		System.gc();
	}
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Count: "+Counter.count);
	System.exit(0);
}
}
