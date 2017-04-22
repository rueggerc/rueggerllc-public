package com.rueggerllc.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY,
	   region="com.rueggerllc.beans.Pet")
@Table(name="pet")
@NamedQueries
({
  @NamedQuery(name="pet.findAll",query="select p from Pet p"),
  @NamedQuery(name="pet.findByName", query="select p from Pet p where p.name=:name")
})

@SuppressWarnings("serial")
public class Pet {

  private static final Logger log = Logger.getLogger(Pet.class);
	
  @Id 
  @GeneratedValue(generator = "pet_id_generator")
  @GenericGenerator(name="pet_id_generator", strategy = "uuid")
  @Column(name="id")
  private String id;
  
  @Column(name="name")
  private String name;
  
  @OneToOne(mappedBy="pet", cascade=CascadeType.ALL)
  private PetDetails petDetails;

  public String getId() {
	  return id;
  }

  public void setId(String id) {
	  this.id = id;
  }

  public String getName() {
	  return name;
  }

  public void setName(String name) {
	  this.name = name;
  }

  public PetDetails getPetDetails() {
	  return petDetails;
  }

  public void setPetDetails(PetDetails petDetails) {
	  this.petDetails = petDetails;
	  petDetails.setPet(this);
  }
  
  

  


}
