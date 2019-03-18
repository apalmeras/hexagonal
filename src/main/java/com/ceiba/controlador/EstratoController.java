package com.ceiba.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.dominio.EstratoDTO;
import com.ceiba.servicio.EstratoService;

@RestController
@RequestMapping("/apiv1/estratos")
public class EstratoController {
	@Autowired
	private EstratoService estratoService;

	@PostMapping
	public EstratoDTO guardar(@RequestBody EstratoDTO estratoDTO) {
		return estratoService.guardar(estratoDTO);
	}

}
