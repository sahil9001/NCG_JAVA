package com.adobe.prj.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.adobe.prj.entity.Book;

@Repository
public class BookDaoJdbcImpl implements BookDao {
	@Autowired
	@Qualifier("customerDS")
	private DataSource ds; // pool of db connection
	@Override
	public void addBook(Book b) {
		try {
			Connection con = ds.getConnection(); // get one connection from pool
			// PreparedStatment ps = con.prepareStatement(..)
			System.out.println("using RDBMS book is stored " + con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
