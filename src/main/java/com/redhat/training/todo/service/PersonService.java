package com.redhat.training.todo.service;

import javax.ejb.Stateless;

import com.redhat.training.todo.model.Person;

@Stateless
public class PersonService {

	public PersonService() {
		// TODO Auto-generated constructor stub
	}
	
	public String sayHello(String nombre) {
		//log.info("Adding new task: " + item.getDescription());
		//item.setId((long) (itemRepository.getItemCount() + 1));
		Person p = new Person();
		p.setNombre(nombre);
		return "Hola " + p.getNombre();
	}
	
}
