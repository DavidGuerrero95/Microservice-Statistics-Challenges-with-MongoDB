package com.retos.app.estadisticas.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estadisticas")
public class Estadisticas {

	@Id
	private String id;
	
	@Indexed(unique = true)
	private String nombre;
	
	private List<Integer> likes;

	public Estadisticas() {
	}

	public Estadisticas(String nombre, List<Integer> likes) {
		super();
		this.nombre = nombre;
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

	public List<Integer> getLikes() {
		return likes;
	}

	public void setLikes(List<Integer> likes) {
		this.likes = likes;
	}
	
	
	
}
