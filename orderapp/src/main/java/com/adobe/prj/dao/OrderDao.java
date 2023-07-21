package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adobe.prj.dto.ReportDTO;
import com.adobe.prj.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	@Query("select new com.adobe.prj.dto.ReportDTO(o.orderDate, o.total,c.firstName, c.lastName, c.email) from Order o left join o.customer c")
	List<ReportDTO> getReport();
}
