package com.ceiba.dominio.excepcion;

public class ExistePropietarioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExistePropietarioException(String mensaje) {
		super(mensaje);
	}

	public ExistePropietarioException(String mensaje, Throwable throwable) {
		super(mensaje, throwable);
	}

}
