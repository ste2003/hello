package com.redhat.training.todo.ui;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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
	
	String mensaje;
	String name;
	List<Person> lista;
	
	private Group currentGroup;
	
	@Inject
	private GroupRepository groupRepo;
	
	@Inject
	private PersonRepository personRepo;
	
	@PostConstruct
	public void setGroup() {
		currentGroup = groupRepo.findById((long)1); 	
	}

	public void listAllPersons(){
		currentGroup.setId((long)1);
		currentGroup.setName("probando grupo");
		lista = personRepo.findAllPersonsForGroup(currentGroup);
		//name = personRepo.findAllPersonsForGroup();
		this.mensaje = lista.toString(); 
		System.out.println(this.mensaje);
		return ;	
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
}
