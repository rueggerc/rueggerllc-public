package com.rueggerllc.beans;

import java.util.List;

public class Foo {

	private String name = "Fred";
	private int age;
	private Dakota dakota;
	
	private List<String> administrators;
	
	public Foo() {
		
	}
  
	public Foo(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(List<String> administrators) {
		this.administrators = administrators;
	}

	public Dakota getDakota() {
		return dakota;
	}

	public void setDakota(Dakota dakota) {
		this.dakota = dakota;
	}
		

  
}
