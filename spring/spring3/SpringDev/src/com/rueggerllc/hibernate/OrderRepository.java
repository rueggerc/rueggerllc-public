package com.rueggerllc.hibernate;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.rueggerllc.hibernate.domain.Order;

public interface OrderRepository extends BaseRepository {
	
	@Transactional(readOnly=true)
	public List<Order> findHighPriorityOrders();
	
	@Transactional(readOnly=true)
	public Order findOrderByName(String name);
}
