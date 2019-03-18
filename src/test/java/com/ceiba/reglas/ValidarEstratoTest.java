package com.ceiba.reglas;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.ceiba.dominio.excepcion.EstratoNoValidoException;
import com.ceiba.servicio.EstratoService;
import com.ceiba.servicio.reglas.ValidarEstrato;

public class ValidarEstratoTest {

	public static final String DIRECCION = "Buenos aires";
	public static final Integer ESTRATO_4 = 4;
	public static final Integer ESTRATO_3 = 3;

	@Test
	public void validarEstrato() {
		EstratoService estratoService = mock(EstratoService.class);
		ValidarEstrato validarEstrato = new ValidarEstrato(estratoService);
		when(estratoService.getCalificacionPorDireccion(DIRECCION)).thenReturn(ESTRATO_4);

		try {
			validarEstrato.verificar(DIRECCION, ESTRATO_3);
		} catch (EstratoNoValidoException e) {
			assertEquals(e.getMessage(), ValidarEstrato.MENSAJE + ESTRATO_4);
		}
	}
	
	@Test
	public void validarEstratoOk() {
		EstratoService estratoService = mock(EstratoService.class);
		ValidarEstrato validarEstrato = new ValidarEstrato(estratoService);
		when(estratoService.getCalificacionPorDireccion(DIRECCION)).thenReturn(ESTRATO_3);
		validarEstrato.verificar(DIRECCION, ESTRATO_3);
	}

}
