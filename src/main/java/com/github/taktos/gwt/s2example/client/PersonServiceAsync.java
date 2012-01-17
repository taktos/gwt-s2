package com.github.taktos.gwt.s2example.client;

import com.github.taktos.gwt.s2example.shared.Person;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PersonServiceAsync {

	void getPerson(String name, AsyncCallback<Person> callback);

}
