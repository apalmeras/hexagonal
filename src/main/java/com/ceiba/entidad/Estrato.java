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

@Entity(name = "estrato")
@Table(name = "estrato")

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Estrato {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "clasificacion")
	private Integer clasificacion;
	@Column(name = "direccion")
	private String direccion;

}
