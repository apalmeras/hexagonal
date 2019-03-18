package com.ceiba.servicio.reglas;

import com.ceiba.dominio.excepcion.EstratoNoValidoException;
import com.ceiba.servicio.EstratoService;

public class ValidarEstrato {

	public static final String MENSAJE = "El estrato para esta direccion es ";

	private EstratoService estratoService;

	public ValidarEstrato(EstratoService estratoService) {
		this.estratoService = estratoService;
	}

	public void verificar(String direccion, Integer estrato) {
		Integer estratoEsperado = estratoService.getCalificacionPorDireccion(direccion);
		if (estrato != estratoEsperado) {
			throw new EstratoNoValidoException(MENSAJE + estratoEsperado);
		}
	}

}
