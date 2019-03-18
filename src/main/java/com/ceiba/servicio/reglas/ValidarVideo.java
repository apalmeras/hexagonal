package com.ceiba.servicio.reglas;

import com.ceiba.dominio.ReclamacionDTO;
import com.ceiba.servicio.ReclamacionService;

public class ValidarVideo {

	public static final String MENSAJE = "El video no cumple con los requerimientos ";
	
	private ReclamacionService reclamacionService;
	
	public ValidarVideo(ReclamacionService reclamacionService) {
		this.reclamacionService= reclamacionService;
	}
	
	
	public void verificar(String ruta) {
		
		ReclamacionDTO reclamacion = reclamacionService.buscar(new Long(1));
		
	}
}
	
