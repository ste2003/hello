package com.redhat.training.todo.ui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.redhat.training.todo.data.GroupRepository;
import com.redhat.training.todo.data.PersonRepository;
import com.redhat.training.todo.model.Group;
import com.redhat.training.todo.model.Person;
import com.redhat.training.todo.service.PersonService;

@RequestScoped
@Named("hello")
public class PersonHello {
	
	private String mensaje;
	private String name;
	private List<Person> lista;
	private Set<Person> persons;
	Set<Group> groups;
	private Group currentGroup;
	
	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}


	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}


	@Inject
	private GroupRepository groupRepo;
	
	@Inject
	private PersonRepository personRepo;
	
	@PostConstruct
	public void setGroup() {		
		
		currentGroup = groupRepo.findById((long)1);
		groups = groupRepo.getAllGroups();
		System.out.println("*********** en setGroup***************"+groups);
	}


	public void listAllPersons(){
		System.out.println("en listAllPersons antes ");
		//currentGroup.setId((long)1);
		//currentGroup.setName("sistemas");
		System.out.println("en listAllPersons luego ");
		lista = personRepo.findAllPersonsForGroup(currentGroup);
		//name = personRepo.findAllPersonsForGroup();
		//this.mensaje = lista.toString(); 
		System.out.println("lista de personas  " + lista);
		return ;	
	}
	
	public List<Person> getLista() {
		return lista;
	}

	public void setLista(List<Person> lista) {
		this.lista = lista;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public Group getCurrentGroup() {
		return currentGroup;
	}

	public void setCurrentGroup(Group currentGroup) {
		this.currentGroup = currentGroup;
	}
	
	public List<Person> getPersonList(){
		if(persons != null) {
			return new ArrayList<Person>(persons);
		} else {
			return new ArrayList<Person>();
		}
	}
	public void update(ValueChangeEvent event) {
		System.out.println("!!!!!!!!!!! event "+event.getNewValue());
		Group group = (Group) event.getNewValue();
		System.out.println("grupo en upda*******" + group);
		Set<Person> persona = new HashSet<Person>();
		//persona = group
		persons = new HashSet<Person>(group.getPersons());
	}
}
