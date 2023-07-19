package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Product;

public interface ProductDao {
	void addProduct(Product product) throws PersistenceException;
	List<Product> getProducts() throws FetchException;
	Product getProduct(int id) throws FetchException;
}
