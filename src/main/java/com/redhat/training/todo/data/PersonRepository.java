package com.redhat.training.todo.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.redhat.training.todo.model.Person;


@ApplicationScoped
public class PersonRepository {
	
	//@Inject
	//private EntityManager em;
	
	private List<Person> myPersonList;
	
	public Person findById(Long id) {
		/*
		 * Person p = new Person(); p.setId((long)1); p.setName("personal1");
		 */
		return null;
	}
	
	//@PostConstruct
	public void seedTodoList() {
		
	}
	public List<Person> findAllPersons(){
		
		System.out.println("en PersonRepo findallpersonsforgroup...");
		// return list
		return null;
	}
}

