package com.adobe.prj.entity;

import com.adobe.prj.annotations.Column;
import com.adobe.prj.annotations.Table;

@Table(name = "emp")
public class Employee {
	private int id;
	private String firstName;
	private String email;

	public Employee() {
	}

	public Employee(int id, String firstName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.email = email;
	}

	@Column(name = "EMP_ID", type = "NUMERIC(12)")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "email", type = "VARCHAR(100)")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
