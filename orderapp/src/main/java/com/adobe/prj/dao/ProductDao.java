package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adobe.prj.entity.Product;
// Product ==> CRUD operations for Product entity
// PK is Integer type
public interface ProductDao extends JpaRepository<Product, Integer> {
	// select * from products where category = ?
	List<Product> findByCategory(String category);
	
	// select * from products where category = ? and quantity = ?
	List<Product> findByCategoryAndQuantity(String category, int quantity);
	
//	@Query(value = "select * from products where price >= :l and price <= :h", nativeQuery = true)
	@Query("from Product where price >= :l and price <= :h")
	List<Product> findByRange(@Param("l") double low, @Param("h") double high);
}

// Spring Data JPA ==> generates class i.e., @Repository class with predefined methods
