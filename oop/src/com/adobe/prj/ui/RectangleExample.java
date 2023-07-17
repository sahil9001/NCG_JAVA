package com.adobe.prj.ui;

import com.adobe.prj.entity.Rectangle;

public class RectangleExample {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(4,5);
		Rectangle r2 = new Rectangle(4,5);
		
		if(r1 == r2) {
			System.out.println("same");
		}
		
		if(r1.equals(r2)) {
			System.out.println("similar");
		}
		
		Rectangle ref = r1;
		if(r1 == ref) {
			System.out.println("same r1 == ref");
		}
	}

}
