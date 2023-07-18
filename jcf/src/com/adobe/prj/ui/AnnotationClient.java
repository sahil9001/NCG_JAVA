package com.adobe.prj.ui;

import com.adobe.prj.entity.Employee;
import com.adobe.prj.util.SQLUtil;

public class AnnotationClient {

	public static void main(String[] args) {
		String SQL = SQLUtil.generateCreateSQLStatement(Employee.class);
		System.out.println(SQL);
		
		Employee e = new Employee(45,"Raj Kumar", "rajk@adobe.com");
		
		SQL = SQLUtil.generateInsertSQL(e);
		// insert into emps values(45, 'Raj Kumar', 'rajk@adobe.com');
	}

}
