package com.adobe.prj.ui;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;

// CMD + SHIFT + O for auto import
public class ProductClient {

	public static void main(String[] args) {
		Product[] products = new Product[4]; // array of references
		
		products[0] = new Tv(12, "Sony Bravia", 2_10_000.00, "OLED"); //up casting
		products[1] = new Mobile(42, "One Plus nord", 89000.00, "4G"); //up casting
		products[2] = new Mobile(75, "Nokia", 2500.00, "3G");//up casting
		products[3] = new Tv(7, "Onida", 3500.00, "CRT");//up casting
		
		displayProducts(products);
	}

	private static void displayProducts(Product[] products) {
		for(Product p : products) {
			System.out.println(p.getName() + ", " + p.getPrice());
			
			// to avoid ClassCastException, we need type checking
			if(p instanceof Tv) {
				Tv t = (Tv) p; // down casting
				System.out.println(t.getScreenType());
			} else if(p.getClass() == Mobile.class) { // strict checking
				Mobile m = (Mobile) p; 
				System.out.println(m.getConnectivity());
			}
			System.out.println("****");
		}
			
	}

}
