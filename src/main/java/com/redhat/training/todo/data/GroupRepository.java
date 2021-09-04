package com.redhat.training.todo.data;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


import javax.enterprise.context.ApplicationScoped;

import com.redhat.training.todo.model.Group;

@ApplicationScoped
public class GroupRepository {
	public Group findById(Long id) {
		Group g = new Group();
		g.setId((long)1);
		g.setName("grupo1");
		return g;
	}
	
	public Set<Group> getAllGroups(){
		// Set<String> s = new HashSet<String>();
		Set<Group> groups = new HashSet<Group>();
		//Set<Foo> set = new HashSet<Foo>();
	    //set.add(new Foo("Hello"));
	    
		Group g1 = new Group();
		Group g2 = new Group();
		g1.setId((long)1);
		g1.setName("sistemas");
		g2.setId((long)2);
		g2.setName("soporte");
		
		groups.add(g1);
		groups.add(g2);
		return groups;
	}
	
}
