package com.adobe.prj.entity;

import java.util.Objects;

import com.adobe.prj.util.IComparable;

public class Rectangle implements IComparable {
	private int width;
	private int breadth;
	
	public Rectangle() {
	}
	public Rectangle(int width, int breadth) {
		this.width = width;
		this.breadth = breadth;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	// equals() is inherited from Object class
	
	
	@Override
	public int compare(Object other) {
		Rectangle r = (Rectangle) other;
		return (this.breadth * this.width) - (r.width * r.breadth);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + breadth;
		result = prime * result + width;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (breadth != other.breadth)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", breadth=" + breadth + "]";
	}
	
	
	
}
