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
import com.redhat.training.todo.service.GrupoService;
import com.redhat.training.todo.service.PersonService;

@RequestScoped
@Named("hello")
public class PersonHello {
	
	private String mensaje;
	private String name;
	private List<Person> lista;
	private Set<Person> persons;
	Set<Grupo> grupos;
	private Grupo currentGrupo;
	private Person currentPerson;
	
	@Inject
	private GrupoRepository grupoRepo;
	
	@Inject
	private PersonRepository personRepo;
	
	@EJB
	private PersonService personService;
	
	@EJB
	private GrupoService grupoService;
	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	
	@PostConstruct
	public void setGrupo() {		
		//this.startDB(); //me repetia la carga
		//currentGrupo = grupoRepo.findById((long)1);
		currentPerson = personRepo.findById((long)1);
		grupos = grupoService.getAllGrupoSets();
		//List<Grupo> myList;
		//myList = grupoService.getAllGrupos();
		//grupos = (Set<Grupo>) grupoService.getAllGrupos();
		System.out.println("*********** en setGrupo***************"+grupos);
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
	public void listAllPersons(){
		System.out.println("en listAllPersons PersonHello ");

		lista = personRepo.findAllPersonsForGrupo(currentGrupo);
		//name = personRepo.findAllPersonsForGrupo();
		//this.mensaje = lista.toString(); 
		System.out.println("lista de personas  " + lista);
		return ;	
	}
	
	public
	List<Person> getPersonList(){		
		if(persons != null) {
			return new ArrayList<Person>(persons);
		} else {
			return new ArrayList<Person>();
		}
	}
	public void update(ValueChangeEvent event) {
		System.out.println("!!!!!!!!!!! event "+event.getNewValue());
		Grupo grupo = (Grupo) event.getNewValue();
		System.out.println("grupo en upda*******" + grupo);
		//Set<Person> personas = grupo.getPersons();
		//for (Person persona : personas) {
		//	System.out.println("* " + persona.toString());
		//}
		this.persons = grupo.getPersons();
		for (Person person : persons) {
			System.out.println("* " + person.toString());
		}
		
		//persons = new HashSet<Person>(Grupo.getPersons());
		//persona = Grupo
		//lista = (List<Person>) persons;
	}
	public void startDB() {
		//personRepo.seedTodoList();
		//GrupoRepo.seedTodoList();
		/*
		 * Grupo g1 = new Grupo(); g1.setName("Sistemas"); Grupo g2 = new Grupo();
		 * g2.setName("Soporte"); Grupo g3 = new Grupo(); g3.setName("Redes");
		 * grupoService.register(g1); grupoService.register(g2);
		 * grupoService.register(g3); Person p1 = new Person(); p1.setName("Juan");
		 * p1.setGrupo(g1); personService.register(p1); this.listAllPersons();
		 */
	}

	public Person getCurrentPerson() {
		return currentPerson;
	}

	public void setCurrentPerson(Person currentPerson) {
		this.currentPerson = currentPerson;
	}
}
