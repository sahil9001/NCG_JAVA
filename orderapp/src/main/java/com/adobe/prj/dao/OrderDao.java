package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adobe.prj.dto.ReportDTO;
import com.adobe.prj.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	@Query("select new com.adobe.prj.dto.ReportDTO(o.orderDate, o.total,c.firstName, c.lastName, c.email) from Order o left join o.customer c")
	List<ReportDTO> getReport();
	
	//http://localhost:8080/api/orders/byDate?orderDate=2023-07-21
	@Query(value = "select * from orders where DATE(order_date) = :od", nativeQuery = true)
	List<Order> getOrder(@Param("od") String date);
}
