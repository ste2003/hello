package com.redhat.training.todo.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.redhat.training.todo.model.Grupo;

@ApplicationScoped
public class GrupoRepository {
	
	/*
	 * @Inject private EntityManager em;
	 */
	
	private Set<Grupo> myGrupoList;
	
	public Grupo findById(Long id) {
		//Grupo g = new Grupo();
		// g = null;
		/*
		 * g.setId((long)1); g.setName("grupo1");
		 */
		return null;
	}
	@PostConstruct
	public void seedTodoList() {
		/*
		 * myGrupoList = new HashSet<Grupo>(); myGrupoList.add(new Grupo((long)1,
		 * "sistemas")); myGrupoList.add(new Grupo((long)2, "soporte"));
		 * myGrupoList.add(new Grupo((long)3, "redes"));
		 * System.out.println("----------- En GrupoRepository " + myGrupoList);
		 */
		
	}
	public Set<Grupo> getAllGrupos(){
		// Set<String> s = new HashSet<String>();
		Set<Grupo> Grupos = new HashSet<Grupo>();	    
		/*
		 * Grupo g1 = new Grupo(); Grupo g2 = new Grupo(); g1.setId((long)1);
		 * g1.setName("sistemas"); g2.setId((long)2); g2.setName("soporte");
		 * 
		 * Grupos.add(g1); Grupos.add(g2);
		 * return Grupos;
		 */
		if (myGrupoList == null) {
			myGrupoList = new HashSet<Grupo>();
		}
		return myGrupoList;
	}
	
}
