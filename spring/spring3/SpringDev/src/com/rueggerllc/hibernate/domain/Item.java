package com.rueggerllc.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="item")
public class Item {

	@Id
	@Column (name="id")
	@GeneratedValue(generator = "item_id_generator")
	@GenericGenerator(name = "item_id_generator", strategy = "uuid")
	private String id;
	
	@Column (name="name")
	private String name;

	@Column (name="serial_number")
	private String serialNumber;
	
	@ManyToOne
	@JoinColumn(name="order_id")
    private Order order;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	


}
