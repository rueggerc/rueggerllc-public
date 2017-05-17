package com.rueggerllc.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY,
	   region="com.rueggerllc.beans.PetDetails")
@Table(name="pet_details")
public class PetDetails {

  private static final Logger log = Logger.getLogger(PetDetails.class);
	
  @Id 
  @Column(name="pet_id", unique=true, nullable=false)
  @GeneratedValue(generator = "gen")
  @GenericGenerator(name="gen", strategy = "foreign", parameters=@Parameter(name="property", value="pet"))
  private String pet_id;
 
  
  @Column(name="description")
  private String description;
  
  @OneToOne
  @PrimaryKeyJoinColumn
  private Pet pet;
  
  @Column(name="birth_date")
  private Date birthDate;
 
  @Column(name="species")
  private String species;
  
  @Column(name="weight")
  private double weight;
  
  @Column(name="age")
  private int age;
  
  @Column(name="color")
  private String color;
  


  public String getDescription() {
	  return description;
  }


  public void setDescription(String description) {
	  this.description = description;
  }


  public String getPet_id() {
	  return pet_id;
  }


  public void setPet_id(String pet_id) {
	  this.pet_id = pet_id;
  }


  public String getSpecies() {
	  return species;
  }


  public void setSpecies(String species) {
	  this.species = species;
  }


  public double getWeight() {
	  return weight;
  }


  public void setWeight(double weight) {
	  this.weight = weight;
  }

  public Date getBirthDate() {
	return birthDate;
  }


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	public int getAge() {
		  return age;
	}


  public void setAge(int age) {
	  this.age = age;
  }


  public String getColor() {
	  return color;
  }


  public void setColor(String color) {
	  this.color = color;
  }




   public Pet getPet() {
	  return pet;
  }


  public void setPet(Pet pet) {
	  this.pet = pet;
  }


  public static Logger getLog() {
	  return log;
  }



}
