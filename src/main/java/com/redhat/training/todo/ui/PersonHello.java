package com.redhat.training.todo.ui;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.redhat.training.todo.service.PersonService;

@RequestScoped
@Named("hello")
public class PersonHello {
	
	String mensaje;

	@EJB
	private PersonService personService;
	
	public String sayHello() {
		this.mensaje = personService.sayHello("Ana");
		return this.mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
