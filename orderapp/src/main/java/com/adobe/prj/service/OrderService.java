package com.adobe.prj.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.CustomerDao;
import com.adobe.prj.dao.OrderDao;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dto.ReportDTO;
import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.LineItem;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private OrderDao orderDao;
	
	public List<Product> byRange(double low, double high) {
		return productDao.findByRange(low, high);
	}
	
	public List<Order> getOrders() {
		return orderDao.findAll();
	}
	
	@Transactional 
	public void placeOrder(Order order) {
		List<LineItem> items = order.getItems();
		double total = 0.0;
		for(LineItem item : items) {
			Product p = productDao.findById(item.getProduct().getId()).get();
			if(p.getQuantity() < item.getQty()) {
				throw new IllegalArgumentException("No Product in Stock!!!");
			}
			p.setQuantity(p.getQuantity() - item.getQty()); // DIRTY checking --> UPDATE
			item.setAmount(p.getPrice() * item.getQty());
			total += item.getAmount();
		}
		order.setTotal(total);
		order.setOrderDate(new Date());
		orderDao.save(order); // insert into orders table and also items table
	}
	
	
	public Customer addCustomer(Customer c) {
		return customerDao.save(c);
	}
	
	public List<Customer> getCustomers() {
		return customerDao.findAll();
	}
	
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	
	public Product addProduct(Product p) {
		return productDao.save(p);
	}
	
	public Product getProductById(int id) throws EntityNotFoundException {
		Optional<Product> opt = productDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new EntityNotFoundException("Product with id " + id + " doesn't exist!!!");
		}
	}

	public List<ReportDTO> getReport() {
		return orderDao.getReport();
	}
	
	public List<Order> getOrder(String date) {
		return orderDao.getOrder(date);
	}
	
	@Transactional
	public Product updateProduct(int id, Product p) throws EntityNotFoundException {
		Product product = productDao.findById(id).get();
		product.setPrice(p.getPrice()); // just modifying price; ==> DIRTY Checking --> update
		return product;
	}
}
