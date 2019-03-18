package com.ceiba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.dominio.SeguroDTO;
import com.ceiba.servicio.SeguroService;

@RestController
@RequestMapping("/apiv1/seguros")
public class SeguroController {
	@Autowired
	private SeguroService seguroService;

	@PostMapping
	public SeguroDTO guardar(@RequestBody SeguroDTO seguroDTO) {
		return seguroService.guardar(seguroDTO);
	}
	
	@GetMapping
	public List<SeguroDTO> listar() {
		return seguroService.listar();
	}
}
