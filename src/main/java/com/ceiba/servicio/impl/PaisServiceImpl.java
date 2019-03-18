package com.ceiba.servicio.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.dominio.PaisDTO;
import com.ceiba.dominio.excepcion.RegistroNoExisteException;
import com.ceiba.entidad.Pais;
import com.ceiba.respositorio.PaisRepository;
import com.ceiba.servicio.PaisService;
@Service
public class PaisServiceImpl implements PaisService {
	@Autowired
	private PaisRepository paisRepository;

	@Override
	public List<PaisDTO> listar() {
		return paisRepository.findAll().stream().map(PaisServiceImpl::convertirADominio).collect(Collectors.toList());
	}

	public static PaisDTO convertirADominio(Pais pais) {
		return new PaisDTO(pais.getId(), pais.getCodigo(), pais.getIdioma(), pais.getMoneda());
	}

	public static Pais convertirAEntidad(PaisDTO paisDTO) {
		return new Pais(paisDTO.getId(), paisDTO.getCodigo(), paisDTO.getIdioma(), paisDTO.getMoneda());
	}

	@Override
	public PaisDTO guardar(PaisDTO paisDTO) {
		Pais pais = convertirAEntidad(paisDTO);
		paisRepository.save(pais);
		return convertirADominio(pais);
	}

	@Override
	public PaisDTO consultar(Long id) {
		Optional<Pais> optPais = paisRepository.findById(id);
		if (optPais.isPresent()) {
			return convertirADominio(optPais.get());
		}
		throw new RegistroNoExisteException("pais no encontrado");
	}
}
