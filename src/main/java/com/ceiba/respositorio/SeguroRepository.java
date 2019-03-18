package com.ceiba.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ceiba.entidad.Seguro;

public interface SeguroRepository  extends JpaRepository<Seguro, Long>, JpaSpecificationExecutor<Seguro> {

}
