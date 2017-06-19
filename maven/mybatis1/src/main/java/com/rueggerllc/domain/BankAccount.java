package com.rueggerllc.domain;

import java.sql.Timestamp;

public class BankAccount {
	
	private int id;
	private String name;
	private String address;
	private String state;
	private String zip;
	private Timestamp createDate;
	private int status;
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("BankAccount.id: " + id);
		buffer.append("\nBankAccount.name: " + name);
		buffer.append("\nBankAccount.address: " + address);
		buffer.append("\nBankAccount.state: " + state);
		buffer.append("\nBankAccount.zip: " + zip);
		buffer.append("\nBankAccount.createDate: " + createDate);
		buffer.append("\nBankAccount.status: " + status);
		return buffer.toString();
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	


}
