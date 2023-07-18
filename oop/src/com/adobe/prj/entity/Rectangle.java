package com.adobe.prj.entity;

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
	
	// r1.equals(r2) ==> this refers to "r1" and "obj" is referencing r2
	@Override
	public boolean equals(Object obj) {
		Rectangle rect = (Rectangle) obj;
		if(this.width == rect.width && this.breadth == rect.breadth) {
			return true;
		}
		return false;
	}
	@Override
	public int compare(Object other) {
		Rectangle r = (Rectangle) other;
		return (this.breadth * this.width) - (r.width * r.breadth);
	}
	
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", breadth=" + breadth + "]";
	}
	
	
}
