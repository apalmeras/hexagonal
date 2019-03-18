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
@Table(name = "inmueble")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Inmueble {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "metraje")
	private String metraje;

	@Column(name = "estrato")
	private Integer estrato;

	@Column(name = "valor")
	private Double valor;
}
