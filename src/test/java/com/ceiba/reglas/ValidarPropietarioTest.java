package com.ceiba.reglas;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.ceiba.dominio.PropietarioDTO;
import com.ceiba.dominio.excepcion.ExistePropietarioException;
import com.ceiba.servicio.PropietarioService;
import com.ceiba.servicio.reglas.ValidarPropietario;

public class ValidarPropietarioTest {

	public static final String CEDULA = "1140844836";
	public PropietarioDTO propietarioNull = null;
	public PropietarioDTO propietarioNotNull = new PropietarioDTO(Long.parseLong("1"),"1140844836","ARMANDO PALMERA");
	

	@Test
	public void validarPropietario() {
		PropietarioService propietarioService = mock(PropietarioService.class);
		ValidarPropietario validarPropietario = new ValidarPropietario(propietarioService);
		
		PropietarioDTO propietario = null;
		
		when(propietarioService.buscarPorCedula(CEDULA)).thenReturn(propietario);

		try {
			validarPropietario.verificar(CEDULA);
		} catch (ExistePropietarioException e) {
			assertEquals(e.getMessage(), ValidarPropietario.MENSAJE );
		}
	}
	
	@Test
	public void validarEstratoOk() {
		PropietarioService propietarioService = mock(PropietarioService.class);
		ValidarPropietario validarPropietario = new ValidarPropietario(propietarioService);
		when(propietarioService.buscarPorCedula(CEDULA)).thenReturn(propietarioNull);
		validarPropietario.verificar(CEDULA);
	}
}
