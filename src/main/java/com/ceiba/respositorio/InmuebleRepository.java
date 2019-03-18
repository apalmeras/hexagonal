package com.ceiba.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ceiba.entidad.Inmueble;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long>, JpaSpecificationExecutor<Inmueble> {
  
}
