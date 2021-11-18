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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.redhat.training.todo.data.PersonRepository;

import com.redhat.training.todo.model.Person;

import com.redhat.training.todo.service.PersonService;

@RequestScoped
@Named("hello")
public class PersonHello {
	
	
	private String mensaje;
	private String genero;
	private String tiempo;
	private String resuelto;
	private String sugerencia;
	private String cursos;
	private String currentGrupo;
	private Set<Person> persons;
	private Set<String> grupos;
	private List<Person> lista;
	
	
	private Person currentPerson;
	
	
	
	@Inject
	private PersonRepository personRepo;
	
	@EJB
	private PersonService personService;
	


	
	@PostConstruct
	public void setGrupo() {
		
	}	
	
	public void cargarGrupos() {
		grupos = new HashSet<String>();
		grupos.add("1ra Circuns");
		grupos.add("2da Circuns");
		grupos.add("3ra Circuns");
	}	
	public void listar() {
		lista = personService.getAllPersons();
		System.out.println("*********** en listar ***************");
		System.out.println(lista);
	}
	public String save() {
		
		System.out.println("*********** en save ***************");
		//this.currentPerson.setGrupo(currentGrupo);
		//this.currentPerson.setGenero(currentGenero);
		//this.currentPerson.setTiempo(currentRadio);
		//Person p = this.currentPerson;
		Person guardar = new Person();
	
		System.out.println(this.currentGrupo);
		System.out.println(this.genero);
		
		
		guardar.setGenero(this.genero);
		guardar.setTiempo(this.tiempo);
		guardar.setResuelto(this.resuelto);
		guardar.setGrupo(currentGrupo);
		guardar.setSugerencia(sugerencia);
		guardar.setCursos(this.cursos);
		
	
		this.mensaje = personService.register(guardar);
		
		//this.mensaje = "Muchas gracias!";
		System.out.println("*****");
	
		
		//System.out.println(lista);
		
		//lista = personRepo.findAllPersonsForGrupo(currentGrupo);
		//System.out.println(lista);
		//System.out.println(persons);
		/*
		 * for (Person person : persons) { System.out.println("* " + person.toString());
		 * }
		 */
		return this.mensaje;
	}

	
	public List<Person> getPersonList()	{ 
		if(lista != null) {
		  System.out.println("*********** en getPersonList() ***************");
		  System.out.println(lista); return new ArrayList<Person>(lista); 
		  } else {
			  return new ArrayList<Person>(); 
		  } 
	}
	 
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCurrentGrupo() {
		return currentGrupo;
	}

	public void setCurrentGrupo(String currentGrupo) {
		this.currentGrupo = currentGrupo;
	}
	
	public Person getCurrentPerson() {
		return currentPerson;
	}

	public void setCurrentPerson(Person currentPerson) {
		this.currentPerson = currentPerson;
	}	

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getResuelto() {
		return resuelto;
	}

	public void setResuelto(String resuelto) {
		this.resuelto = resuelto;
	}

	public String getSugerencia() {
		return sugerencia;
	}

	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}

	public String getCursos() {
		return cursos;
	}

	public void setCursos(String cursos) {
		this.cursos = cursos;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public Set<String> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<String> grupos) {
		this.grupos = grupos;
	}

}
