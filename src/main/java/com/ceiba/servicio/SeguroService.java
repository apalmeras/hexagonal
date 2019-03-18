package com.ceiba.servicio;

import java.util.List;

import com.ceiba.dominio.SeguroDTO;

public interface SeguroService {
	SeguroDTO guardar(SeguroDTO seguroDTO);
	SeguroDTO consultar(Long id);
	List<SeguroDTO> listar();
	List<SeguroDTO> listarPorPropietario(Long idPropietario);
}
