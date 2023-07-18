package com.adobe.prj.ui;

import java.util.HashSet;
import java.util.Set;

import com.adobe.prj.entity.Product;

public class SetExample {

	public static void main(String[] args) {
		Set<Product> products = new HashSet<>();
		products.add(new Product(34, "Wacom", 4500.00, "computer"));
		products.add(new Product(51, "Sony Bravia", 210000.00, "tv"));
		products.add(new Product(1, "LG Joy", 150000.00, "tv" ));
		products.add(new Product(32, "Logitech", 900.00, "computer"));
		products.add(new Product(4, "iPhone", 98000.00, "mobile"));
		products.add(new Product(8, "OnePlus", 78000.00, "mobile"));
		products.add(new Product(51, "Sony Bravia", 210000.00, "tv")); // duplicate element --> not added
		
		for(Product p : products) {
			System.out.println(p);
		}
		
	}

}
