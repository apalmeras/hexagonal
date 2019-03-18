package com.ceiba.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaisDTO {
	private Long id;
	private String codigo;
	private String idioma;
	private String moneda;

}
