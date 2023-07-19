<%@page import="com.adobe.prj.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
	<h1>Product List</h1>
	<table border="1">
		<tr>
			<th>ID</th> <th>Name</th><th>Price</th>
		</tr>
		<%
			List<Product> products = (List<Product>) request.getAttribute("products");
			for(Product p: products) {
		%>
			<tr>
				<td> <%= p.getId() %> </td>
				<td> <%= p.getName() %> </td>
				<td> <%= p.getPrice() %> </td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>