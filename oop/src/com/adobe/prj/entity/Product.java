package com.adobe.prj.entity;

import com.adobe.prj.util.IComparable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Product implements IComparable {
	private int id;
	private String name;
	private double price;
	
//	public boolean isExpensive() {
//		return false;
//	}
	
	public abstract boolean isExpensive();

	@Override
	public int compare(Object other) {
		Product p = (Product) other;
//		if(this.price > p.price) {
//			return 1;
//		} else if (p.price > this.price) {
//			return -1;
//		}
//		return 0;
		return Double.compare(this.price, p.price);
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	} // pure virtual 
	
	
}
