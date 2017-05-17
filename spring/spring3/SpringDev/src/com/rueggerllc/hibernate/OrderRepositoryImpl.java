package com.rueggerllc.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.rueggerllc.hibernate.domain.Order;

// @Repository
public class OrderRepositoryImpl extends BaseRepositoryImpl implements OrderRepository  {
	
	public List<Order> findHighPriorityOrders() {
		Session session = getSessionFactory().getCurrentSession();
	    Query q = session.getNamedQuery("order.findHighPriorityOrders");
	    List<Order> orders = (List<Order>)q.list();
	    return orders;
	}
	
	public Order findOrderByName(String name) {
		System.out.println("JAVA TEMP DIR=" + System.getProperty("java.io.tmpdir"));
		Session session = getSessionFactory().getCurrentSession();
	    Query q = session.getNamedQuery("order.findOrderByName");
	    q.setString("name", name);
	    Order order = (Order)q.uniqueResult();
	    return order;
	}
	
}
