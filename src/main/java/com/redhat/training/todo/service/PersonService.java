package com.redhat.training.todo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	public String register(Person p){
		em.persist(p);	
		return "Su encuesta fue registrada. Muchas gracias!";
	}
	
	public List<Person> getAllPersons(){
		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
		List<Person> persons = query.getResultList();
		return persons;

	}
	
	

}
