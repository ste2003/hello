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

import com.redhat.training.todo.data.GrupoRepository;
import com.redhat.training.todo.data.PersonRepository;
import com.redhat.training.todo.model.Grupo;
import com.redhat.training.todo.model.Person;
import com.redhat.training.todo.service.PersonService;

@RequestScoped
@Named("hello")
public class PersonHello {
	
	private String mensaje;
	private String name;
	private List<Person> lista;
	private Set<Person> persons;
	Set<Grupo> Grupos;
	private Grupo currentGrupo;
	
	public Set<Grupo> getGrupos() {
		return Grupos;
	}

	public void setGrupos(Set<Grupo> Grupos) {
		this.Grupos = Grupos;
	}


	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}


	@Inject
	private GrupoRepository GrupoRepo;
	
	@Inject
	private PersonRepository personRepo;
	
	@PostConstruct
	public void setGrupo() {		
		personRepo.seedTodoList();
		GrupoRepo.seedTodoList();
		currentGrupo = GrupoRepo.findById((long)1);
		Grupos = GrupoRepo.getAllGrupos();
		System.out.println("*********** en setGrupo***************"+Grupos);
	}


	public void listAllPersons(){
		System.out.println("en listAllPersons PersonHello ");

		lista = personRepo.findAllPersonsForGrupo(currentGrupo);
		//name = personRepo.findAllPersonsForGrupo();
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

	public Grupo getCurrentGrupo() {
		return currentGrupo;
	}

	public void setCurrentGrupo(Grupo currentGrupo) {
		this.currentGrupo = currentGrupo;
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
		Grupo Grupo = (Grupo) event.getNewValue();
		System.out.println("grupo en upda*******" + Grupo);
		//persons = new HashSet<Person>(Grupo.getPersons());
		//persona = Grupo
		//lista = (List<Person>) persons;
	}
	public void startDB() {
		personRepo.seedTodoList();
		GrupoRepo.seedTodoList();
	}
}
