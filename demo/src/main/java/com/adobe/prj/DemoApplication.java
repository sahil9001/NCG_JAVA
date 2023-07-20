package com.adobe.prj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.adobe.prj.entity.Book;
import com.adobe.prj.service.LibraryService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		Book b = new Book();
		LibraryService service = ctx.getBean("libraryService", LibraryService.class);
		service.insertBook(b);
	}

}
