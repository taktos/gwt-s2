package com.github.taktos.gwt.s2example.client;

import com.github.taktos.gwt.s2example.shared.Person;
import com.github.taktos.gwt.s2example.shared.PersonNotFoundException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("../remoteService")
public interface PersonService extends RemoteService {

	Person getPerson(String name) throws PersonNotFoundException;
}
