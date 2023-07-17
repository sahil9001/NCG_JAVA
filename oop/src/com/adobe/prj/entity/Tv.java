package com.adobe.prj.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Tv extends Product {
	private String screenType;
	
	public Tv(int id, String name, double price, String type) {
		super(id, name, price);
		this.screenType = type;
	}

	@Override
	public boolean isExpensive() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
