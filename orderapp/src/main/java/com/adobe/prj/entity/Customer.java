package com.adobe.prj.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "customers")
public class Customer {
	@Id
	private String email;
	
	@Column(name="fname", length = 100)
	private String firstName;
	
	@Column(name="lname")
	private String lastName;
}
