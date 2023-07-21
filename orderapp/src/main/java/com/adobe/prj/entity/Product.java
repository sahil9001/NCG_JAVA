package com.adobe.prj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private int id;

	@NotBlank(message = "Name is required")
	private String name;

	@Min(value = 100, message = "Price ${validatedValue} should be more than {value}")
	private double price;
	private String category;

	@Min(value = 0, message = "Quantity ${validatedValue} should be more than {value}")
	private int quantity;
}
