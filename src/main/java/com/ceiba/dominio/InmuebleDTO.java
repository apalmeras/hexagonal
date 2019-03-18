package com.ceiba.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InmuebleDTO {
	private Long id;
	private String tipo;
	private String direccion;
	private String metraje;
	private Integer estrato;
	private Double valor;
}
