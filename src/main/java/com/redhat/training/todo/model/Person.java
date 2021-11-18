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
	
	private String sugerencia;
	
	private String genero;
	
	private String tiempo;

	private String resuelto;

	private String cursos;
	
	private String grupo;
	
	
	
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Person() {
		this.setSugerencia("constructor");				
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
	public String getSugerencia() {
		return sugerencia;
	}
	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", sugerencia=" + sugerencia + ", genero=" + genero + ", tiempo=" + tiempo
				+ ", resuelto=" + resuelto + ", cursos=" + cursos + ", grupo=" + grupo + "]";
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getResuelto() {
		return resuelto;
	}

	public void setResuelto(String resuelto) {
		this.resuelto = resuelto;
	}

	public String getCursos() {
		return cursos;
	}

	public void setCursos(String cursos) {
		this.cursos = cursos;
	}

	/*
	 * public Group getGroup() { return group; } public void setGroup(Group group) {
	 * this.group = group; }
	 */
	
}
