package com.redhat.training.todo.service;

import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.redhat.training.todo.data.GrupoRepository;
import com.redhat.training.todo.model.Grupo;

@Stateless
public class GrupoService {
	
	@PersistenceContext()
	private EntityManager em;
	
	
	@Inject
	GrupoRepository grupoRepository;
	
	public void register(Grupo g){
		em.persist(g);
		
	}
	public void remove(Long id){
		
	}
	public void update(Grupo g){
		
	}
	public Set<Grupo> getAllGrupos(){
		return grupoRepository.getAllGrupos();
	}

}
