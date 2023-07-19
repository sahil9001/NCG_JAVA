package com.adobe.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.adobe.prj.dao.FetchException;
import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); // character stream to browser / client
		response.setContentType("text/html"); // MIME type
		out.print("<html>");
		out.print("<body>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> ID </th>");
		out.print("<th> Name </th>");
		out.print("<th> Price </th>");
		out.print("<th> Category </th>");
		out.print("</tr>");
		ProductDao productDao = new ProductDaoJdbcImpl();

		try {
			List<Product> products = productDao.getProducts();
			for (Product p : products) {
				out.print("<tr>");
				out.print("<td>" + p.getId() + "</td>");
				out.print("<td>" + p.getName() + "</td>");
				out.print("<td>" + p.getPrice() + "</td>");
				out.print("<td>" + p.getCategory() + "</td>");
				out.print("</tr>");
			}
		} catch (FetchException e) {
			e.printStackTrace();
		}
		out.print("</body>");
		out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDao productDao = new ProductDaoJdbcImpl();

		Product p = Product.builder()
				.name(request.getParameter("name"))
				.price(Double.parseDouble(request.getParameter("price")))
				.quantity(200)
				.category(request.getParameter("category"))
				.build();

		try {
			productDao.addProduct(p);
			response.sendRedirect("index.html");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

}
