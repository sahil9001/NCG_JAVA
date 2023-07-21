package com.adobe.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.EntityNotFoundException;
import com.adobe.prj.service.OrderService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	@Autowired
	private OrderService service;

	// GET http://localhost:8080/api/products
	// GET http://localhost:8080/api/products?low=5000&high=40000 // Query
	// Parameters
	@GetMapping()
	public List<Product> getProducts(@RequestParam(name = "low", defaultValue = "0.0") double low,
			@RequestParam(name = "high", defaultValue = "0.0") double high) {
		if (low == 0.0 && high == 0.0) {
			return service.getProducts();
		} else {
			return service.byRange(low, high);
		}
	}

	// GET http://localhost:8080/api/products/3 // PathParameter
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") int id) throws EntityNotFoundException {
		return service.getProductById(id);
	}

	// @ResponseBody is optional for return type
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED) //201
	public Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}

}
