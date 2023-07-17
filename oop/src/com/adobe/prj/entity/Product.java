package com.adobe.prj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Product {
	private int id;
	private String name;
	private double price;
	
//	public boolean isExpensive() {
//		return false;
//	}
	
	public abstract boolean isExpensive();

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	} // pure virtual 
	
	
}
