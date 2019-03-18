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

import com.ceiba.dominio.PropietarioDTO;
import com.ceiba.servicio.PropietarioService;

@RestController
@RequestMapping("/apiv1/propietarios")
@CrossOrigin("*")
public class PropietarioController {

	@Autowired
	private PropietarioService propietarioService;

	@PostMapping
	public PropietarioDTO guardar(@RequestBody PropietarioDTO propietarioDTO) {
		return propietarioService.guardar(propietarioDTO);
	}

	@GetMapping(value = "/{id}")
	public PropietarioDTO consultar(@PathVariable Long id) {
		return propietarioService.consultar(id);
	}

	@PutMapping
	public PropietarioDTO editar(@RequestBody PropietarioDTO propietarioDTO) {
		return propietarioService.editar(propietarioDTO);
	}

	@GetMapping
	public List<PropietarioDTO> listar() {
		return propietarioService.listar();
	}
	
	@DeleteMapping(value = "/{id}")
	public void elimina(@PathVariable Long id) {
		this.propietarioService.eliminar(id);
	}
}
