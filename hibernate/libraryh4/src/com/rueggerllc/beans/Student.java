package com.rueggerllc.beans;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY,
	   region="com.rueggerllc.beans.Student")
@Table(name="student")
@NamedQueries
({
  @NamedQuery(name="student.findAll",query="select s from Student s")
})

@SuppressWarnings("serial")
public class Student {

	private static final Logger log = Logger.getLogger(Student.class.getName());
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private Long id;
  
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="status")
	private int status;
	
	@ManyToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(name="student_course",
	           joinColumns={@JoinColumn(name="student_id")},
	           inverseJoinColumns={@JoinColumn(name="course_id")})
	private Set<Course> courses = new HashSet<Course>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	
  
}
