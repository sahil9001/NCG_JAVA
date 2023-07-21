package com.adobe.prj.dto;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReportDTO {
	Date orderDate;
	double total;
	String firstName;
	String lastName;
	String email;
}
