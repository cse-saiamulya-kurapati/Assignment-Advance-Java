package com.capgemini.mockitounit;

public class Calculator {
	private MathService ms;
	
	public Calculator(MathService ms) {
		this.ms=ms;
	}
	public int add(int a,int b) {
		return ms.add(a, b);
	}
}
