package com.redhat.training.todo.ui;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.redhat.training.todo.service.PersonService;

@RequestScoped
@Named("hello")
public class PersonHello {

	@EJB
	private PersonService personService;
	
	public String sayHello() {
		return personService.sayHello("Ana");
	}
}
