package com.redhat.training.todo.ui;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.redhat.training.todo.model.Person;

@RequestScoped
@Named("group")
public class GrupoHello {
	private String nombre;
	
	private Person person;
	
	

}
