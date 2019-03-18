package com.ceiba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.dominio.ReclamacionDTO;
import com.ceiba.servicio.ReclamacionService;

@RestController
@RequestMapping("/apiv1/reclamacion")
@CrossOrigin("*")
public class ReclamacionController {

	@Autowired
	private ReclamacionService reclamacionService;

	@PostMapping
	public ReclamacionDTO guardar(@RequestBody ReclamacionDTO reclamacionDTO) {
		return reclamacionService.guardar(reclamacionDTO);
	}

	@GetMapping(value = "/{id}")
	public ReclamacionDTO consultar(@PathVariable Long id) {
		return reclamacionService.buscar(id);
	}

	@PutMapping
	public ReclamacionDTO editar(@RequestBody ReclamacionDTO reclamacionDTO) {
		return reclamacionService.editar(reclamacionDTO);
	}

	@GetMapping
	public List<ReclamacionDTO> listar() {
		return reclamacionService.listar();
	}
	
	@DeleteMapping(value = "/{id}")
	public void elimina(@PathVariable Long id) {
		this.reclamacionService.eliminar(id);
	}
}
