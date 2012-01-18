package com.github.taktos.gwt.s2example.server;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.taktos.gwt.s2example.shared.Person;
import com.github.taktos.gwt.s2example.shared.PersonNotFoundException;

public class PersonServiceImplTest extends PersonServiceImpl {

	@Test
	public void testGetPerson_Found() {
		Person person = getPerson("Hanako");

		assertNotNull(person);
		assertEquals("Hanako", person.getFirstName());
		assertEquals("Yamada", person.getLastName());
		assertEquals(Integer.valueOf(17), person.getAge());
	}

	@Test
	public void testGetPerson_NotFound() throws Exception {
		try {
			getPerson("nanashi");
			fail("MUST be thrown an exception!");
		} catch (PersonNotFoundException e) {
			assertEquals("nanashi", e.getMessage());
		} catch (Exception e) {
			fail("MUST be thrown PersonNotFoundException");
		}
	}
}
