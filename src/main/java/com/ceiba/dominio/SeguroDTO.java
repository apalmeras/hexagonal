package com.ceiba.dominio;

import com.ceiba.entidad.Inmueble;
import com.ceiba.entidad.Pais;
import com.ceiba.entidad.Propietario;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SeguroDTO {
	private Long id;
	private Inmueble inmueble;
	private Propietario propietario;
	private Pais pais;
	private String estado;
	private String fecha;
	private Double valor;

	public SeguroDTO(Long id, Inmueble inmueble, Propietario propietario, Pais pais, String estado, String fecha,
			Double valor) {
		this.id = id;
		this.estado = estado;
		this.fecha = fecha;
		this.valor = valor;
		this.inmueble = inmueble;
		this.pais = pais;
		this.propietario = propietario;
	}

}
