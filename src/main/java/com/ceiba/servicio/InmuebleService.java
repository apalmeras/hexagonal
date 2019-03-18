package com.ceiba.servicio;

import java.util.List;

import com.ceiba.dominio.InmuebleDTO;

public interface InmuebleService {
	
	InmuebleDTO guardar(InmuebleDTO inmuebleDTO);
	InmuebleDTO consultar(Long id);
	List<InmuebleDTO> listar();
	
	
}
