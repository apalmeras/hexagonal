package com.ceiba.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ceiba.entidad.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>, JpaSpecificationExecutor<Pais> {

}
