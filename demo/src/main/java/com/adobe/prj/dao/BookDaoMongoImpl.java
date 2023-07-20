package com.adobe.prj.dao;

import org.springframework.stereotype.Repository;

import com.adobe.prj.entity.Book;

@Repository
public class BookDaoMongoImpl implements BookDao {

	@Override
	public void addBook(Book b) {
		System.out.println("Mongo Store...");
	}

}
