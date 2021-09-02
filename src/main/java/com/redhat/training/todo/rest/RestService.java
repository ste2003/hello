package com.redhat.training.todo.rest;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.training.todo.service.PersonService;



@Path("/")
@RequestScoped
public class RestService {
	@EJB
	PersonService personService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloRest(){
		System.out.println("en get*********************");
		return personService.sayHello("Ana");
		
	}
	
	@GET
	@Path("bye")
	@Produces(MediaType.APPLICATION_JSON)
	public String sayBye(){
		System.out.println("en bye*********************");
		return personService.sayHello("Bye Ana");
		
	}
	
	@GET
	@Path("{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public String hello(@PathParam("nombre") String nombre){
		System.out.println("en hello*********************");
		return personService.sayHello(nombre);
		
	}
	
	@GET
	@Path("/probando/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public String probando(@PathParam("nombre") String nombre){
		System.out.println("en probando*********************");
		return personService.sayHello(nombre);
		
	}
}



