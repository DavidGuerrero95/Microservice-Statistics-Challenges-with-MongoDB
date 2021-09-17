package com.retos.app.estadisticas.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.retos.app.estadisticas.models.Suscripciones;

@FeignClient(name = "app-suscripcionesretos")
public interface SuscripcionesRetosFeignClient {

	@GetMapping("/suscripciones/verNombre/{nombre}")
	public Suscripciones verNombre(@PathVariable("nombre") String nombre);

}
