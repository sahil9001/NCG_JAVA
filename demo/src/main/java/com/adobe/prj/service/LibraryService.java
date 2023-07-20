package com.adobe.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.BookDao;
import com.adobe.prj.entity.Book;

@Service
public class LibraryService {
	
	@Autowired
	private BookDao bookDao; // interface ==> Spring Container is going to wire the dependency
	
	// private BookDao bookDao = new BookDaoJdbcImpl();
	// private BookDao bookDao = BookDaoFactory.getBookDao(); 
	public void insertBook(Book b) {
		bookDao.addBook(b); 
	}
}
