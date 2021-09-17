package com.retos.app.estadisticas.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.retos.app.estadisticas.clients.SuscripcionesRetosFeignClient;
import com.retos.app.estadisticas.models.Estadisticas;
import com.retos.app.estadisticas.models.Suscripciones;
import com.retos.app.estadisticas.repository.EstadisticasRepository;

@RestController
public class EstadisticasController {

	@Autowired
	EstadisticasRepository estadisticas;

	@Autowired
	SuscripcionesRetosFeignClient suscripcionesRetos;

	@PostMapping("/estadistica/crear")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void crearEstadistica(@RequestParam String nombre) {
		Estadisticas est = new Estadisticas();
		est.setNombre(nombre);
		est.setLikes(new ArrayList<Integer>());
		estadisticas.save(est);
	}

	@PutMapping("/estadistica/editarLikes/{nombre}")
	@ResponseStatus(code = HttpStatus.OK)
	public void editarLikes(@PathVariable("nombre") String nombre, @RequestBody Suscripciones suscripciones) {
		Estadisticas esta = estadisticas.findByNombre(nombre);
		Suscripciones sus = suscripcionesRetos.verNombre(suscripciones.getNombre());
		List<Integer> like = new ArrayList<Integer>();
		for (int i = 0; i < sus.getLikes().size(); i++) {
			like.add(sus.getLikes().get(i).size());
		}
		esta.setLikes(like);
		estadisticas.save(esta);
	}

	@GetMapping("/estadistica/verIdeas/{nombre}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<String> verIdeasLikes(@PathVariable("nombre") String nombre) {
		Suscripciones sus = suscripcionesRetos.verNombre(nombre);
		Estadisticas esta = estadisticas.findByNombre(nombre);
		List<String> ideas = new ArrayList<String>();
		List<Integer> likes = esta.getLikes();
		List<Integer> posLikes = new ArrayList<Integer>();
		for (int i = 0; i < likes.size(); i++) {
			Integer Mayor = likes.stream().max(Comparator.naturalOrder()).get();
			posLikes.add(likes.indexOf(Mayor));
			likes.set(likes.indexOf(Mayor), -1);
		}

		for (int i = 0; i < posLikes.size(); i++) {
			ideas.add(sus.getIdeas().get(posLikes.get(i)));
		}
		return ideas;

	}

}
