package com.ceiba.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import com.ceiba.entidad.Propietario;

public interface PropietarioRepository extends JpaRepository<Propietario, Long>, JpaSpecificationExecutor<Propietario> {
	
	public Propietario findByCedula(String nombre);
}
