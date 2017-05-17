package com.rueggerllc.hibernate.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="com.rueggerllc.hibernate.domain.Order")
@Table(name="customer_order")
@NamedQueries
({
  @NamedQuery(name="order.findHighPriorityOrders",query="select o from Order o where o.status > 500"),
  @NamedQuery(name="order.findOrderByName", query="select o from Order o where o.name=:name")
})
public class Order {

	@Id
	@Column (name="id")
	@GeneratedValue(generator = "order_id_generator")
	@GenericGenerator(name = "order_id_generator", strategy = "uuid")
	private String id;
	
	@Column (name="name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	private List<Item> items = new ArrayList<Item>();
	
	@Column (name="status")
	private int status;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public void add(Item item) {
		item.setOrder(this);
		items.add(item);
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Order.id: " +id);
		buffer.append("\nOrder.name: " + name);
		buffer.append("\nOrder.status: " + status);
		return buffer.toString();
	}
	


}
