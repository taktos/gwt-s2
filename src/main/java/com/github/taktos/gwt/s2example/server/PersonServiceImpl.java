package com.github.taktos.gwt.s2example.server;

import com.github.taktos.gwt.s2example.client.PersonService;
import com.github.taktos.gwt.s2example.shared.Person;
import com.github.taktos.gwt.s2example.shared.PersonNotFoundException;

public class PersonServiceImpl implements PersonService {

	public Person getPerson(String name) {
		if ("Hanako".equals(name)) {
			return new Person("Hanako", "Yamada", 17);
		}
		throw new PersonNotFoundException(name);
	}

}
