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

import com.ceiba.dominio.TipoInmuebleDTO;
import com.ceiba.servicio.TipoInmuebleService;

@RestController
@RequestMapping("/apiv1/tipoInmueble")
@CrossOrigin("*")
public class TipoInmuebleController {

	@Autowired
	private TipoInmuebleService tipoInmuebleService;

	@PostMapping
	public TipoInmuebleDTO guardar(@RequestBody TipoInmuebleDTO tipoInmuebleDTO) {
		return tipoInmuebleService.guardar(tipoInmuebleDTO);
	}

	@GetMapping(value = "/{id}")
	public TipoInmuebleDTO consultar(@PathVariable Long id) {
		return tipoInmuebleService.consultar(id);
	}

	@PutMapping
	public TipoInmuebleDTO editar(@RequestBody TipoInmuebleDTO tipoInmuebleDTO) {
		return tipoInmuebleService.editar(tipoInmuebleDTO);
	}

	@GetMapping
	public List<TipoInmuebleDTO> listar() {
		return tipoInmuebleService.listar();
	}
	
	@DeleteMapping(value = "/{id}")
	public void elimina(@PathVariable Long id) {
		this.tipoInmuebleService.eliminar(id);
	}
}
