package com.adobe.prj.ui;

interface Computation {
	int compute(int x, int y);
}

public class LambdaExample {

	public static void main(String[] args) {
		// Anonymous class
		Computation c1 = new Computation() {
			@Override
			public int compute(int x, int y) {
				return x + y;
			}
		};
		
		System.out.println(c1.compute(4, 5)); // 9
		
		// Lambda expression
		Computation c2 = (int x, int y) -> {
			return x - y;
		};
		
		System.out.println(c2.compute(12, 4)); // 8
		
		// lambda expression -> type inference
		
		Computation c3 = (x,y) -> x * y;
		
		System.out.println(c3.compute(5, 4)); // 20
	}

}
