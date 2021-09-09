package com.redhat.training.todo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.redhat.training.todo.data.GrupoRepository;
import com.redhat.training.todo.model.Grupo;
import com.redhat.training.todo.model.Person;

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
	public List<Grupo> getAllGrupos(){
		TypedQuery<Grupo> query = em.createQuery("SELECT g FROM Grupo g", Grupo.class);
		List<Grupo> grupos = query.getResultList();
		return grupos;

		//return grupoRepository.getAllGrupos();
	}
	public Set<Grupo> getAllGrupoSets(){
		TypedQuery<Grupo> query = em.createQuery("SELECT g FROM Grupo g" , Grupo.class);
			 
		return new HashSet<Grupo>(query.getResultList());
	}

}
