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
	private String genero;
	private String tiempo;
	private String resuelto;
	private String sugerencia;
	private String cursos;
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

	
	@PostConstruct
	public void setGrupo() {				
		grupos = grupoService.getAllGrupoSets();		
		System.out.println("*********** en setGrupo currentPerson***************"+this.currentPerson);
		System.out.println("*********** en setGrupo currentGrupo***************"+this.currentGrupo);
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
		return this.mensaje;
	}
	
	public void updateG(ValueChangeEvent event) {
		System.out.println("!!!!!!!!!!! event "+event.getNewValue());
		Grupo grupo = (Grupo) event.getNewValue();
		System.out.println("grupo en upda*******" + grupo);
		
		
		
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
	
	public Person getCurrentPerson() {
		return currentPerson;
	}

	public void setCurrentPerson(Person currentPerson) {
		this.currentPerson = currentPerson;
	}

	public GrupoRepository getGrupoRepo() {
		return grupoRepo;
	}

	public void setGrupoRepo(GrupoRepository grupoRepo) {
		this.grupoRepo = grupoRepo;
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


}
