package com.rueggerllc.test;


import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rueggerllc.hibernate.OrderRepository;
import com.rueggerllc.hibernate.domain.Item;
import com.rueggerllc.hibernate.domain.Order;

@ContextConfiguration("/resource/applicationContext-hibernate.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
@Transactional
public class HibernateTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	private static Logger logger = Logger.getLogger(HibernateTest.class);
	
	@Autowired
	OrderRepository orderRepository;
	
	@BeforeClass
	public static void setupClass()
	  throws Exception {
	}
	
	@AfterClass
	public static void tearDownClass()
	  throws Exception {
	}
	
	@Before
	public  void setupTest()
	  throws Exception {
	}
	
	@After
	public void tearDownTest()
	  throws Exception {
	}

	@Test
	@Ignore
	@Rollback(true)
	public void createInitialOrders() {
		try {
		  for (int i = 0; i < 100; i++) {
		    Order order = new Order();
		    order.setName("Order" + i);
		    order.setStatus(i*100);
		    createItems(order);
		    orderRepository.save(order);
		    logger.info("Order Saved: " + order.getId());
		  }
		} catch (Exception e) {
			logger.info("ERROR:\n" + e);
		}
	}
	
	
	@Test
	// @Ignore
	@Rollback(false)
	public void testGetAllOrders() {
		try {
			List<Order> orders = orderRepository.findAll(Order.class);
			logger.info("Got Orders: " + orders.size());
			// String orderId = orders.get(0).getId();
			// Order order0 = orderRepository.read(Order.class, orderId);
			// logger.info("Order0 Id=" + order0.getId());
			
		} catch (Exception e) {
			logger.info("ERROR:\n" + e);
		}
	}
	
	@Test
	@Ignore
	@Rollback(false)
	public void testGetOrderByName() {
		try {
			Order order = orderRepository.findOrderByName("Order6");
			assertNotNull(order);			
		} catch (Exception e) {
			logger.info("ERROR:\n" + e);
		}
	}
	
	
	@Test
	@Ignore
	@Rollback(false)
	public void testGetHighPriorityOrders() {
		try {
			List<Order> orders = orderRepository.findHighPriorityOrders();
			assertNotNull(orders);
			assertTrue(orders.size() > 0);
			logger.info("# of High Priority Orders=" + orders.size());
		} catch (Exception e) {
			logger.info("ERROR:\n" + e);
		}
	}
	
	
	private void createItems(Order order) {
		for (int i = 0; i < 3; i++) {
			Item item = new Item();
			item.setName("Item" + i);
			item.setSerialNumber("100330203" + i);
			order.add(item);
		}
	}
	
}
