package com.ceiba.servicio;

import java.util.List;

import com.ceiba.dominio.TipoInmuebleDTO;

public interface TipoInmuebleService {
	
	TipoInmuebleDTO guardar(TipoInmuebleDTO inmuebleDTO);
	
	TipoInmuebleDTO consultar(Long id);
	
	List<TipoInmuebleDTO> listar();
	
	TipoInmuebleDTO editar(TipoInmuebleDTO inmuebleDTO);
	
	void eliminar(Long id);
	
}
