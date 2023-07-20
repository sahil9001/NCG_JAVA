package com.adobe.prj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Customer;
import com.adobe.prj.service.OrderService;

@Component
@Order(1)
public class CustomerClient implements CommandLineRunner {
	@Autowired
	private OrderService service;
	
	// code gets executed automatically once Spring container is created
	@Override
	public void run(String... args) throws Exception {
		//addCustomers();
	}

	private void addCustomers() {
		service.addCustomer(Customer.builder().email("sam@adobe.com")
				.firstName("Samanta").lastName("Ruth").build());
		
		service.addCustomer(Customer.builder().email("raj@adobe.com")
				.firstName("Raj").lastName("Kumar").build());
	}
}
