package com.retos.app.estadisticas.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "suscripciones")
public class Suscripciones {

	@Id
	private String id;

	@Indexed(unique = true)
	private String nombre;
	
	private List<String> creadorIdea;

	private List<String> ideas;

	private List<List<List<String>>> comentarios;

	private List<List<String>> likes;

	public Suscripciones() {
	}

	public Suscripciones(String nombre, List<String> creadorIdea, List<String> ideas,
			List<List<List<String>>> comentarios, List<List<String>> likes) {
		super();
		this.nombre = nombre;
		this.creadorIdea = creadorIdea;
		this.ideas = ideas;
		this.comentarios = comentarios;
		this.likes = likes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getCreadorIdea() {
		return creadorIdea;
	}

	public void setCreadorIdea(List<String> creadorIdea) {
		this.creadorIdea = creadorIdea;
	}

	public List<String> getIdeas() {
		return ideas;
	}

	public void setIdeas(List<String> ideas) {
		this.ideas = ideas;
	}

	public List<List<List<String>>> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<List<List<String>>> comentarios) {
		this.comentarios = comentarios;
	}

	public List<List<String>> getLikes() {
		return likes;
	}

	public void setLikes(List<List<String>> likes) {
		this.likes = likes;
	}


	
	
}
