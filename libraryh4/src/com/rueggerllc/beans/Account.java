package com.rueggerllc.beans;

import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



// Here is a comment

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY,
	   region="com.rueggerllc.beans.Account")
@Table(name="account")
@NamedQueries
({
  @NamedQuery(name="account.findAll",query="select a from Account a"),
  @NamedQuery(name="account.findByName", query="select a from Account a where a.name=:name")
})

@SuppressWarnings("serial")
public class Account
{

  private static final Logger log = Logger.getLogger(Account.class.getName());
	
  @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
  @Column(name="id")
  private Long id;
  
  @Column(name="name")
  private String name;
  
  @Column(name="address")
  private String address;
  
  @Column(name="state")
  private String state;
  
  @Column(name="zip")
  private String zip;
  
  @Column(name="create_date")
  private Date createDate;
  

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

  public Long getId() {
	  return id;
  }
  
  public void setId(Long id) {
	  this.id = id;
  }

  /*
  public AccountStatus getStatus() {
	  return status;
  }

  public void setStatus(AccountStatus status) {
	  this.status = status;
  }
  */

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
  


  public Date getCreateDate() {
	  return createDate;
  }
  public void setCreateDate(Date createDate) {
	  this.createDate = createDate;
  }

  public String toString()
  {
    StringBuffer buffer = new StringBuffer();
    buffer.append("Account.name: " + name);
    buffer.append("\nAccount.address: " + address);
    buffer.append("\nAccount.state: " + state);
    buffer.append("\nAccount.zip: " + zip);
    buffer.append("\nAccount.createDate: " + createDate);
    // buffer.append("\nAccount.status: " + status);
    return buffer.toString();  
  }

}
