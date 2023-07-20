package com.adobe.prj.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@Component
public class ProductClient implements CommandLineRunner {
	@Autowired
	private OrderService service;
	
	// code gets executed automatically once Spring container is created
	@Override
	public void run(String... args) throws Exception {
		addProduct();
		listProducts();
	}
	

	private void addProduct() {
		Product p = service.addProduct(Product.builder()
				.name("Tata Bing")
				.price(9800.00)
				.category("tv")
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
