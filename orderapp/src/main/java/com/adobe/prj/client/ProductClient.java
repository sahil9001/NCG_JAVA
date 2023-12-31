package com.adobe.prj.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@Component
@Order(2)
public class ProductClient implements CommandLineRunner {
	@Autowired
	private OrderService service;
	
	// code gets executed automatically once Spring container is created
	@Override
	public void run(String... args) throws Exception {
//		addProduct();
		//listProducts();
//		getByRange();
	}
	

	private void getByRange() {
		List<Product> products = service.byRange(5_00, 20_000);
		for(Product p : products) {
			System.out.println(p); // toString()
		}
	}


	private void addProduct() {
		Product p = service.addProduct(Product.builder()
				.name("LG Inverter AC")
				.price(49800.00)
				.category("electrical")
				.quantity(100).build());
		
		service.addProduct(p);
		System.out.println("Product added " + p);
	}


	private void listProducts() {
		List<Product> products = service.getProducts();
		for(Product p : products) {
			System.out.println(p); // toString()
		}
	}

}
