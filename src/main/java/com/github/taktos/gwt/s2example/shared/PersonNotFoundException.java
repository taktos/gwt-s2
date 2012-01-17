package com.github.taktos.gwt.s2example.shared;

public class PersonNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PersonNotFoundException() {
		super();
	}

	public PersonNotFoundException(String name) {
		super(name);
	}
}
