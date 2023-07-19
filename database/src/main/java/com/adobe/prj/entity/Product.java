package com.adobe.prj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
	private int id;
	private String name;
	private double price;
	private String category;
	private int quantity;
}
