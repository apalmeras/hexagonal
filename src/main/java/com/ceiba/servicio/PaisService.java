package com.ceiba.servicio;

import java.util.List;

import com.ceiba.dominio.PaisDTO;


public interface PaisService {
	PaisDTO  guardar(PaisDTO pais);
	PaisDTO consultar(Long id);
	List<PaisDTO> listar();
}
