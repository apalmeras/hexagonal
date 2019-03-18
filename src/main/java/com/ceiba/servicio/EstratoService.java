package com.ceiba.servicio;

import com.ceiba.dominio.EstratoDTO;

public interface EstratoService {

	EstratoDTO guardar(EstratoDTO estrato);

	Integer getCalificacionPorDireccion(String direccion);

}
