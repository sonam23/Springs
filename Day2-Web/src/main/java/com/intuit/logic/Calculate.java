package com.intuit.logic;

import org.springframework.stereotype.Component;

@Component
public class Calculate {
	
	public int add(int a, int b) {
		return a+b;
	}

	public int subtract(int value1, int value2) {
		return value1 - value2;
	}
	
	public double square(int value1) {
		return Math.pow(value1,2);
	
	}

	public int product(int value1, int value2) {
		return value1*value2;
	}

}
