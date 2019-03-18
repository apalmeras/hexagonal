package com.ceiba.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "seguro")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Seguro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_inmueble")
	private Inmueble inmueble;
	@ManyToOne
	@JoinColumn(name = "id_propietario")
	private Propietario propietario;
	@ManyToOne
	@JoinColumn(name = "id_pais")
	private Pais pais;

	@Column(name = "estado")
	private String estado;
	@Column(name = "fecha")
	private String fecha;
	@Column(name = "valor")
	private Double valor;



}
