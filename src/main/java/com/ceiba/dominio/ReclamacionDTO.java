package com.ceiba.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReclamacionDTO {


	private Long id;	
	private Long idSeguro;
	private String ruta;
	private String respuesta;
}
