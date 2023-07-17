package com.adobe.prj.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
//@Data
@Getter
@Setter
public class Mobile extends Product {
	private String connectivity;
	
	public Mobile(int id, String name, double price, String connectivity) {
		super(id, name, price); // this has to be the first statement
		this.connectivity = connectivity;
	}
	
	@Override
	public boolean isExpensive() {
		if("3G".equals(connectivity) && getPrice() > 3500) {
			return true;
		} else if ("4G".equals(connectivity) && getPrice() > 25000) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Mobile [connectivity=" + connectivity + ", ID =" + getId() + ", NAME=" + getName()
				+ ", Price =" + getPrice() + "]";
	}
	
	
}
