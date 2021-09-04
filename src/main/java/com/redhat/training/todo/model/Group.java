package com.redhat.training.todo.model;

import java.util.HashSet;
import java.util.Set;

public class Group {
	
	private Long id;
	private String name;
	private Set<Person> persons;
	
	public Group(Long id, String name) {
		this.id=id;
		this.name=name;		
	}
	public Group() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getPersons() {
		Person p1 = new Person();
		p1.setId((long)1);
		p1.setName("persona1");
		Person p2 = new Person();
		p2.setId((long)2);
		p2.setName("persona2");
		Set<Person> p = new HashSet<Person>();
		p.add(p1);
		p.add(p2);
		return p;
	}

}
