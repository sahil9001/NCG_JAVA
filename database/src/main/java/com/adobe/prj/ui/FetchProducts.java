package com.adobe.prj.ui;

import java.util.List;

import com.adobe.prj.dao.FetchException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

public class FetchProducts {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoJdbcImpl();
		
		try {
			List<Product> products = productDao.getProducts();
			for(Product p : products) {
				System.out.println(p);
			}
		} catch (FetchException e) {
			e.printStackTrace();
		}
	}

}
