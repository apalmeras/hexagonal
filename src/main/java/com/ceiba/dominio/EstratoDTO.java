package com.ceiba.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstratoDTO {
	private Long id;
	private Integer clasificacion;
	private String direccion;
}
