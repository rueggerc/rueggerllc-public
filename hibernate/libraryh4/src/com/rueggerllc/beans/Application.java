package com.rueggerllc.beans;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="account")
@NamedQueries
({
  @NamedQuery(name="account.findAll",query="select a from Account a"),
  @NamedQuery(name="account.findByName", query="select a from Account a where a.name=:name")
})
public class Application {

}
