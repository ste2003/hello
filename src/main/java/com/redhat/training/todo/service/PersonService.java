package com.redhat.training.todo.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.redhat.training.todo.data.PersonRepository;
import com.redhat.training.todo.model.Person;

@Stateless
public class PersonService {
	
	@PersistenceContext()
	private EntityManager em;
	
	
	@Inject
	PersonRepository personRepository;

	public PersonService() {
		// TODO Auto-generated constructor stub
	}
	
	public String sayHello(String name) {
		//log.info("Adding new task: " + item.getDescription());
		//item.setId((long) (itemRepository.getItemCount() + 1));
		Person p = new Person();
		p.setName(name);
		return "Hola " + p.getName();
	}
	
	
}
