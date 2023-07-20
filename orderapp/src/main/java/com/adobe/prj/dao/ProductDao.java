package com.adobe.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adobe.prj.entity.Product;
// Product ==> CRUD operations for Product entity
// PK is Integer type
public interface ProductDao extends JpaRepository<Product, Integer> {

}

// Spring Data JPA ==> generates class i.e., @Repository class with predefined methods
