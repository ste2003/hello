package com.redhat.training.todo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Person implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@ManyToOne
	@JoinColumn(name="grupoID")
	private Grupo grupo;
	//private String grupo;
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Person() {
		this.setName("constructor");				
	}

	/*
	 * public Person(Long id, String name, Group group) {
	 * 
	 * this.name = name; this.group = group; }
	 */
	public Long getId() {
		return id;
	}

	/*
	 * public void setId(Long id) { this.id = id; }
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", grupo=" + grupo + "]";
	}

	/*
	 * public Group getGroup() { return group; } public void setGroup(Group group) {
	 * this.group = group; }
	 */
	
}
