package com.redhat.training.todo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Grupo implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="grupo", fetch=FetchType.LAZY)	
	private Set<Person> persons;
	
	
	public Grupo() {
		this.setName("constructor");
	}
	/*
	 * public Group(Long id, String name) { this.id=id; this.name=name; }
	 */
	
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", name=" + name + ", persons=" +  "]";
	}
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getPersons() {
		/*
		 * Person p1 = new Person(); p1.setId((long)1); p1.setName("persona1"); Person
		 * p2 = new Person(); p2.setId((long)2); p2.setName("persona2"); Set<Person> p =
		 * new HashSet<Person>(); p.add(p1); p.add(p2); return p;
		 */
		//return persons;
		return null;
	}

}
