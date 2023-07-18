package com.adobe.prj.ui;

import java.util.Arrays;

import com.adobe.prj.entity.Product;

public class SortClient {

	public static void main(String[] args) {
		String[] names = {"Scarlett", "Eva", "Charles", "George", "Angelina", "Brad"};
		
		Arrays.sort(names); // natural ordering
		
		for(String name: names) {
			System.out.println(name);
		}
		
		System.out.println("********");
		// comparator for logic by client
//		Arrays.sort(names, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.length() - o2.length();
//			}
//		});
		
		Arrays.sort(names, (o1,o2) -> o1.length() - o2.length());
		for(String name: names) {
			System.out.println(name);
		}
		
		System.out.println("*******");
		
		Product[] products = new Product[6];
		products[0] = new Product(34, "Wacom", 4500.00, "computer");
		products[1] = new Product(51, "Sony Bravia", 210000.00, "tv");
		products[2] = new Product(1, "LG Joy", 150000.00, "tv" );
		products[3] = new Product(32, "Logitech", 900.00, "computer");
		products[4] = new Product(4, "iPhone", 98000.00, "mobile");
		products[5] = new Product(8, "OnePlus", 78000.00, "mobile");
		
		Arrays.sort(products);
		
		for(Product p: products) {
			System.out.println(p);
		}
		
		System.out.println("*****");
		
		Arrays.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
		for(Product p: products) {
			System.out.println(p);
		}
		
		
	}

}
