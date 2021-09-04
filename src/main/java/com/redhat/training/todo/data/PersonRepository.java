package com.redhat.training.todo.data;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.training.todo.model.Group;
import com.redhat.training.todo.model.Person;


@ApplicationScoped
public class PersonRepository {
	
	
	public Person findById(Long id) {
		Person p = new Person();
		p.setId((long)1);
		p.setName("personal1");
		return p;
	}
	
	public List<Person> findAllPersonsForGroup(Group g){
		// List<Person>    parameter currentgroup
		List<Person> list;
		list = new ArrayList<Person>();
		Person p1 = new Person();
		p1.setId((long)1);
		p1.setName("persona1");
		p1.setGrupo((long)1);
		Person p2 = new Person();
		p2.setId((long)2);
		p2.setName("persona2");
		p2.setGrupo((long)2);
		list.add(p1);
		list.add(p2);
		System.out.println("en PersonRepo findallpersonsforgroup..."+list);
		// return list
		return list;
	}
}

