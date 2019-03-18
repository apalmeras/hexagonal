package com.ceiba.dominio;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespuestaErrorDTO {
	private Date fecha;
	private String mensaje;
	private String descripcion;
}
