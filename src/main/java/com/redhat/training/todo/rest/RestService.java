package com.redhat.training.todo.rest;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
	public String sayHello(){
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
}



