package com.citi.training;

public class Sample {
	
	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public Sample(int i) {
		super();
		this.i = i;
	}

	@Override
	public String toString() {
		return "Sample [i=" + i + "]";
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Garbage collecting the object with value " + i);
		super.finalize();
	}
	
	

}
