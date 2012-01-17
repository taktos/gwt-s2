package com.github.taktos.gwt.s2example.shared;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = -1218281453338128717L;
	private String firstName;
	private String lastName;
	private Integer age;

	public Person() {

	}

	public Person(String firstName, String lastName, Integer age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
