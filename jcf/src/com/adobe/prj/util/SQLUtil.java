package com.adobe.prj.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.adobe.prj.annotations.Column;
import com.adobe.prj.annotations.Table;

// to generate DDL and DML for entities
public class SQLUtil {
	// pass Book.class, Employee.class, Product.class
	public static String generateCreateSQLStatement(Class<?> clazz) {
		StringBuilder builder = new StringBuilder();
		Table table = clazz.getAnnotation(Table.class);
		if(table != null) {
			builder.append("create table");
			builder.append(" ");
			builder.append(table.name()) ; 
			builder.append("("); // create table emp (
			Method[] methods = clazz.getDeclaredMethods(); // not inherited methods
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					Column col = m.getAnnotation(Column.class);
					if(col != null) {
						builder.append(col.name());
						builder.append(" ");
						builder.append(col.type());
						builder.append(", "); // create table emp ( EMP_ID NUMERIC(12), FIRST_NAME VARCHAR(255),
					}
				}
			}
			builder.setCharAt(builder.lastIndexOf(","), ')');
		}
		
		return builder.toString();
	}
	
	public static String generateInsertSQL(Object obj) {
		StringBuilder builder = new StringBuilder();
		Table table = obj.getClass().getAnnotation(Table.class);
		if(table != null) {
			builder.append("insert into");
			builder.append(" ");
			builder.append(table.name()) ; 
			builder.append(" values ("); // create table emp (
			Method[] methods = obj.getClass().getDeclaredMethods(); // not inherited methods
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					Column col = m.getAnnotation(Column.class);
					if(col != null) {
						try {
							Object ret = m.invoke(obj);
							// 
						} catch (Exception e) {
							e.printStackTrace();
						} 
					}
				}
			}
			builder.setCharAt(builder.lastIndexOf(","), ')');
		}
		return builder.toString();
	}
}
