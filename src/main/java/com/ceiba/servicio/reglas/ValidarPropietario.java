package com.ceiba.servicio.reglas;

import com.ceiba.dominio.PropietarioDTO;
import com.ceiba.dominio.excepcion.ExistePropietarioException;
import com.ceiba.servicio.PropietarioService;

public class ValidarPropietario {
	
	public static final String MENSAJE = "El propietario ya existe ";
	
	
	private PropietarioService propietarioService;
	
	public ValidarPropietario(PropietarioService propietarioService) {
		this.propietarioService = propietarioService;
	}
	
	public void verificar(String cedula) {
		PropietarioDTO propietatio = propietarioService.buscarPorCedula(cedula);
		if (propietatio != null) {
			throw new ExistePropietarioException(MENSAJE );
		}
	}

}
