package com.ceiba.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reclamacion")

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Reclamacion {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "id_seguro")
	private Long idSeguro;
	
	@Column(name = "ruta")
	private String ruta;
	
	@Column(name = "respuesta")
	private String respuesta;

}
