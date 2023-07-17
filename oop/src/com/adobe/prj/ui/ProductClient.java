package com.adobe.prj.ui;

import java.lang.reflect.Method;

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
		//displayExpensive(products);
		//displayOCP(products);
	}

	// OCP way using REFLECTION API ==> RTTI
	private static void displayOCP(Product[] products) {
		for(Product p : products) {
			Method[] methods = p.getClass().getMethods(); // it's own methods + inherited methods
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					try {
						Object ret = m.invoke(p);
						System.out.println(m.getName().substring(3).toUpperCase() + " : " + ret);
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			System.out.println("********");
		}
	}

	// OCP
	private static void displayExpensive(Product[] products) {
		for(Product p : products) {
			if(p.isExpensive()) { // polymorphism
				System.out.println(p.getName() + " is expensive!!!");
			}
		}
	}

	// Not OCP
	private static void displayProducts(Product[] products) {
		for(Product p : products) {
//			System.out.println(p.getName() + ", " + p.getPrice());
//			
//			// to avoid ClassCastException, we need type checking
//			if(p instanceof Tv) {
//				Tv t = (Tv) p; // down casting
//				System.out.println(t.getScreenType());
//			} else if(p.getClass() == Mobile.class) { // strict checking
//				Mobile m = (Mobile) p; 
//				System.out.println(m.getConnectivity());
//			}
//			System.out.println("****");
			System.out.println(p);
		}
			
	}

}
