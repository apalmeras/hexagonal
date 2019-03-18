package com.ceiba.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ceiba.entidad.TipoInmueble;

public interface TipoInmuebleRepository extends JpaRepository<TipoInmueble, Long>, JpaSpecificationExecutor<TipoInmueble> {

}
