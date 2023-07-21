package com.adobe.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.prj.dto.ReportDTO;
import com.adobe.prj.entity.Order;
import com.adobe.prj.service.OrderService;

@RestController
@RequestMapping("api/orders")
public class OrderController {
	@Autowired
	private OrderService service;

	/*
	 {
    "customer": {email:"sam@adobe.com"},
    	"items" : [
        	{"product": {id: 3}, qty: 1},
        	{"product": {id: 1}, qty: 2}
    	]
	}
	 */
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public String newOrder(@RequestBody Order o) {
		service.placeOrder(o);
		return "Order placed!!!";
	}
	
	// GET http://localhost:8080/api/orders
	@GetMapping()
	public List<Order> getOrders() {
		return service.getOrders();
	}
	
	// GET http://localhost:8080/api/orders/report
	@GetMapping("/report")
	public List<ReportDTO> getReport() {
		return service.getReport();
	}
}
