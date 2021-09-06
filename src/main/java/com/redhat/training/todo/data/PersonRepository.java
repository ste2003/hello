package com.redhat.training.todo.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.redhat.training.todo.model.Grupo;
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
		/*
		 * myPersonList = new ArrayList<Person>(); myPersonList.add(new Person((long)1,
		 * "persona1", new Group((long)1, "sistemas"))); myPersonList.add(new
		 * Person((long)2, "persona2", new Group((long)1, "sistemas")));
		 * myPersonList.add(new Person((long)3, "persona3", new Group((long)1,
		 * "sistemas"))); myPersonList.add(new Person((long)4, "persona4", new
		 * Group((long)3, "redes")));
		 * System.out.println("----------- En PersoRepository " + myPersonList);
		 */
	}
	public List<Person> findAllPersonsForGrupo(Grupo g){
		System.out.println("valor de grupo en PersonRepository " + g);
		
		/*
		 * Group g1 = new Group(); Group g2 = new Group(); g1.setId((long)1);
		 * g1.setName("sistemas"); g2.setId((long)2); g2.setName("soporte");
		 * 
		 * List<Person> list; list = new ArrayList<Person>(); Person p1 = new Person();
		 * p1.setId((long)1); p1.setName("persona1"); p1.setGroup(g1); Person p2 = new
		 * Person(); p2.setId((long)2); p2.setName("persona2"); p2.setGroup(g2);
		 * list.add(p1); list.add(p2);
		 */
		//TypedQuery<Person> query = em.createQuery("SELECT p FROM person where p.group = :gr", Person.class);
		//query.setParameter("gr", g);
		//TypedQuery<Employee> query=entityManager.createQuery("SELECT e from Employee e 
		// where e.salary >?1 or e.empName=?2", Employee.class);
		
		System.out.println("en PersonRepo findallpersonsforgroup...");
		// return list
		return null;
	}
}

