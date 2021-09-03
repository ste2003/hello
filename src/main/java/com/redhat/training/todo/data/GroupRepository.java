package com.redhat.training.todo.data;

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
		return null;
	}
	
}
