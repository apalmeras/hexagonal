package com.ceiba.servicio;

import java.util.List;

import com.ceiba.dominio.PropietarioDTO;

public interface PropietarioService {

	PropietarioDTO guardar(PropietarioDTO propietarioDTO);

	PropietarioDTO consultar(Long id);

	PropietarioDTO editar(PropietarioDTO propietarioDTO);
	
	List<PropietarioDTO> listar();
	
	void eliminar(Long id);
	
	PropietarioDTO buscarPorCedula(String cedula);
	
}
