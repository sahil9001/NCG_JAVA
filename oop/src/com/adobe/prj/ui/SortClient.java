package com.adobe.prj.ui;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Rectangle;
import com.adobe.prj.entity.Tv;
import com.adobe.prj.util.Utility;

public class SortClient {

	public static void main(String[] args) {
		Product[] products = new Product[4]; // array of references
		products[0] = new Tv(12, "Sony Bravia", 2_10_000.00, "OLED"); // up casting
		products[1] = new Mobile(42, "One Plus nord", 89000.00, "4G"); // up casting
		products[2] = new Mobile(75, "Nokia", 2500.00, "3G");// up casting
		products[3] = new Tv(7, "Onida", 3500.00, "CRT");// up casting
		
		Utility.sort(products);
		
		for(Product p : products) {
			System.out.println(p);
		}

		Rectangle[] rects = new Rectangle[5];
		rects[0] = new Rectangle(3,9);
		rects[1] = new Rectangle(2,3);
		rects[2] = new Rectangle(10,1);
		rects[3] = new Rectangle(30,2);
		rects[4] = new Rectangle(3,6);
		
		Utility.sort(rects);
		
		for(Rectangle r: rects) {
			System.out.println(r); // toString()
		}
		
	}

}
