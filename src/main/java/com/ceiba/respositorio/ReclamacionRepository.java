package com.ceiba.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ceiba.entidad.Reclamacion;

public interface ReclamacionRepository extends JpaRepository<Reclamacion, Long>, JpaSpecificationExecutor<Reclamacion>  {

}
