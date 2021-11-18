package com.redhat.training.todo.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.redhat.training.todo.service.PersonService;
import com.redhat.training.todo.model.Person;



@Path("/")
@RequestScoped
public class RestService {
	@EJB
	PersonService personService;
	

	@GET
	@Path("person")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPerson() {
		return personService.getAllPersons();
	}

	
	@POST
	@Path("/person")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person){
		System.out.println("en addPerson*********************");
		Response.ResponseBuilder builder = null;
		
		try{
			if (person.getId() == null){
				personService.register(person);				
				builder = Response.ok();
			}
			else {
				//Ticket ticketToUpdate = look falta
			}
		} catch (Exception e) {
			Map<String, String> responseObj = new HashMap<String, String>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
		}
		return builder.build();
		
	}
}



