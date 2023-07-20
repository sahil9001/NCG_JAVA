package com.adobe.prj.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.LineItem;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@Component
public class OrderClient implements CommandLineRunner {
	@Autowired
	private OrderService service;
	
	@Override
	public void run(String... args) throws Exception {
		Order order = new Order();
		Customer c = Customer.builder().email("sam@adobe.com").build(); // login session
		order.setCustomer(c);
		
		List<LineItem> items = new ArrayList<>();
		items.add(LineItem.builder()
				.product(Product.builder()
						.id(2).build())
				.qty(2)
				.build());
		items.add(LineItem.builder()
				.product(Product.builder()
						.id(1).build())
				.qty(1)
				.build());
		
		order.setItems(items);
		
		service.placeOrder(order);
		System.out.println("Order placed!!!");
		
	}

}
