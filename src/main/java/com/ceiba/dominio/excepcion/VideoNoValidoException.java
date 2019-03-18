package com.ceiba.dominio.excepcion;

public class VideoNoValidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VideoNoValidoException(String mensaje) {
		super(mensaje);
	}

	public VideoNoValidoException(String mensaje, Throwable throwable) {
		super(mensaje, throwable);
	}
}
