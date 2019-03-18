package com.ceiba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.dominio.InmuebleDTO;
import com.ceiba.servicio.InmuebleService;

@RestController
@RequestMapping("/apiv1/inmuebles")
@CrossOrigin("*")
public class InmuebleController {
	@Autowired
	private InmuebleService inmuService;

	@PostMapping
	public InmuebleDTO guardar(@RequestBody InmuebleDTO imInmuebleDTO) {
		return inmuService.guardar(imInmuebleDTO);
	}

	@GetMapping(value = "/{id}")
	public InmuebleDTO consultar(@PathVariable Long id) {
		return inmuService.consultar(id);
	}
	
	@GetMapping
	public List<InmuebleDTO> listar() {
		return inmuService.listar();
	}

}
