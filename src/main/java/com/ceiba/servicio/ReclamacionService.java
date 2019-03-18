package com.ceiba.servicio;

import java.util.List;

import com.ceiba.dominio.ReclamacionDTO;

public interface ReclamacionService {

	ReclamacionDTO guardar(ReclamacionDTO reclamacion);
	
	ReclamacionDTO editar(ReclamacionDTO reclamacion);
	
	List<ReclamacionDTO> listar();
	
	void eliminar(Long id);
	
	ReclamacionDTO buscar(Long id);
}
