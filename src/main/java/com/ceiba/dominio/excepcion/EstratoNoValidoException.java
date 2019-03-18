package com.ceiba.dominio.excepcion;

public class EstratoNoValidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EstratoNoValidoException(String mensaje) {
		super(mensaje);
	}

	public EstratoNoValidoException(String mensaje, Throwable throwable) {
		super(mensaje, throwable);
	}
}
