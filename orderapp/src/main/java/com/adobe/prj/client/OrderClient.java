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
//		addOrder();
		printOrders();
	}

	private void printOrders() {
		List<Order> orders = service.getOrders();
		for(Order o : orders) {
			System.out.println("#############");
			System.out.println(o.getCustomer().getEmail() +", " + o.getOrderDate());
			List<LineItem> items = o.getItems();
			for(LineItem item : items) {
				System.out.println(item.getProduct().getName() +", " + item.getQty() +", " + item.getAmount());
			}
			System.out.println("Total ---> " + o.getTotal());
			System.out.println("***********");
		}
	}

	private void addOrder() {
		Order order = new Order();
		Customer c = Customer.builder().email("raj@adobe.com").build(); // login session
		order.setCustomer(c);
		
		List<LineItem> items = new ArrayList<>();
		items.add(LineItem.builder()
				.product(Product.builder()
						.id(4).build())
				.qty(3)
				.build());
		items.add(LineItem.builder()
				.product(Product.builder()
						.id(3).build())
				.qty(1)
				.build());
		
		order.setItems(items);
		
		service.placeOrder(order);
		System.out.println("Order placed!!!");
		
	}

}
