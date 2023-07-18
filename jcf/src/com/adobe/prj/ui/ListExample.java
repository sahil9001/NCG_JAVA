package com.adobe.prj.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.adobe.prj.entity.Product;

public class ListExample {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(34, "Wacom", 4500.00, "computer"));
		products.add(new Product(51, "Sony Bravia", 210000.00, "tv"));
		products.add(new Product(1, "LG Joy", 150000.00, "tv" ));
		products.add(new Product(32, "Logitech", 900.00, "computer"));
		products.add(new Product(4, "iPhone", 98000.00, "mobile"));
		products.add(new Product(8, "OnePlus", 78000.00, "mobile"));
		
		// natural ordering
		Collections.sort(products);
		
	//	Supports concurrent operations
//		for(int i = 0; i <products.size(); i++) {
//			products.add(new Product());
//			System.out.println(products.get(i)); // index based operation
//		}
		
		// safer iteration --> ConcurrentModification is not allowed
		for(Product p : products) {
//			products.add(new Product());
			System.out.println(p);
		}
		
		// all collections are iterable
//		Iterator<Product> iter = products.iterator();
//		while(iter.hasNext()) {
//			Product p = iter.next();
//			if(p.getCategory().equals("tv")) {
//				iter.remove();
//			}
//			System.out.println(p);
//		}
		
	}

}
