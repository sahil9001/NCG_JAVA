package com.adobe.prj.cfg;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class MyConfig {
	
	// factory method
//	@Bean("orderDS")
	@Bean
	public DataSource getDataSource() throws Exception{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.cj.jdbc.Driver"); //loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/order_app_db" );
		cpds.setUser("root");                                  
		cpds.setPassword("Welcome123");                                  
		// the settings below are optional -- c3p0 can work with defaults
		cpds.setMinPoolSize(5);                                     
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		return cpds;
	}
	
	
//	@Bean("customerDS")
//	public DataSource getCustomerDataSource() throws Exception{
//		ComboPooledDataSource cpds = new ComboPooledDataSource();
//		cpds.setDriverClass("com.mysql.cj.jdbc.Driver"); //loads the jdbc driver            
//		cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/customer_app_db" );
//		cpds.setUser("root");                                  
//		cpds.setPassword("Welcome123");                                  
//		// the settings below are optional -- c3p0 can work with defaults
//		cpds.setMinPoolSize(5);                                     
//		cpds.setAcquireIncrement(5);
//		cpds.setMaxPoolSize(20);
//		return cpds;
//	}
}
