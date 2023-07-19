package com.adobe.prj.ui;

import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

public class InsertProduct {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoJdbcImpl();
		
		Product p = Product.builder()
				.name("Wacom")
				.price(4500.00)
				.quantity(200)
				.category("computer")
				.build();
		
		try {
			productDao.addProduct(p);
			System.out.println("Product added!!!");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

}
