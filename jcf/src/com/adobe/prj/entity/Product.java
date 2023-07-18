package com.adobe.prj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Comparable<Product> {
	private int id;
	private String name;
	private double price;
	private String category;

	
	// Natural comparision
	@Override
	public int compareTo(Product o) {
		return id - o.id;
	}

}
