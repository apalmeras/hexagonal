package com.ceiba.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ceiba.entidad.Estrato;

public interface EstratoRepository  extends JpaRepository<Estrato, Long>, JpaSpecificationExecutor<Estrato> {

	public Estrato findByDireccion(String direccion);
}
