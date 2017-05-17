package com.rueggerllc.jdbc.domain;

import java.util.Date;


public class Account {
  private Long id;
  private String name;
  private String address;
  private String state;
  private String zip;
  private Date createDate;
  private int status;
  
  
  public Long getId() {
	  return id;
  }
  public void setId(Long id) {
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
  public int getStatus() {
	  return status;
  }
  public void setStatus(int status) {
	  this.status = status;
  }
  
  public Date getCreateDate() {
	  return createDate;
  }
  public void setCreateDate(Date createDate) {
	  this.createDate = createDate;
  }
  
  public String toString() {
	    StringBuffer buffer = new StringBuffer();
	    buffer.append("Account.id: " + id);
	    buffer.append("\nAccount.name: " + name);
	    buffer.append("\nAccount.address: " + address);
	    buffer.append("\nAccount.state: " + state);
	    buffer.append("\nAccount.zip:" + zip);
	    buffer.append("\nAccount.createDate:" + createDate);
	    buffer.append("\nAccount.status:" + status);
	    
	    return buffer.toString();
	  }

}
