package com.ceiba.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropietarioDTO {
	private Long id;
	private String cedula;
	private String nombre;
}
