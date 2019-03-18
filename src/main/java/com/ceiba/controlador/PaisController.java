package com.ceiba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.dominio.PaisDTO;
import com.ceiba.servicio.PaisService;

@RestController
@RequestMapping("/apiv1/paises")
public class PaisController {
	@Autowired
	private PaisService paisService;

	@PostMapping
	public PaisDTO guardar(@RequestBody PaisDTO paisDTO) {
		return paisService.guardar(paisDTO);
	}

	@GetMapping
	public List<PaisDTO> listar() {
		return paisService.listar();
	}
}
