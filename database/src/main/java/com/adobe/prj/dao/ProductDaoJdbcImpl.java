package com.adobe.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adobe.prj.entity.Product;

public class ProductDaoJdbcImpl implements ProductDao {

	@Override
	public void addProduct(Product product) throws PersistenceException {
		String SQL = "INSERT INTO products (id, name, price, category, quantity) VALUES (0, ?, ?, ? ,?)";
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getCategory());
			ps.setInt(4, product.getQuantity());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException("unable to add product", e);
		} finally {
			DBUtil.closeConnection(con);
		}
	}

	@Override
	public List<Product> getProducts() throws FetchException {
		String SQL = "SELECT id, name, price, category, quantity FROM products";
		List<Product> products = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				products.add(Product.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.price(rs.getDouble("price"))
						.quantity(rs.getInt("quantity"))
						.category(rs.getString("category")).build());
				
				// products.add(new Product(rs.getInt("id"), 
				// rs.getString("name"), rs.getDouble("price"), 
				// rs.getInt("quantity"), rs.getString("category"));
				
			}
		} catch (SQLException e) {
			throw new FetchException("unable to get products", e);
		} finally {
			DBUtil.closeConnection(con);
		}
		return products;
	}

	@Override
	public Product getProduct(int id) throws FetchException {
		String SQL = "SELECT id, name, price, category, quantity FROM products WHERE id = ?";

		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (SQLException e) {
			throw new FetchException("unable to get product by id " + id, e);
		} finally {
			DBUtil.closeConnection(con);
		}
		return null;
	}

}
