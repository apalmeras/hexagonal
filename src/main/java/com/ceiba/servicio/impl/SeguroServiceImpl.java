package com.ceiba.servicio.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.dominio.SeguroDTO;
import com.ceiba.entidad.Inmueble;
import com.ceiba.entidad.Pais;
import com.ceiba.entidad.Propietario;
import com.ceiba.entidad.Seguro;
import com.ceiba.respositorio.InmuebleRepository;
import com.ceiba.respositorio.PaisRepository;
import com.ceiba.respositorio.PropietarioRepository;
import com.ceiba.respositorio.SeguroRepository;
import com.ceiba.servicio.SeguroService;
import com.ceiba.util.SeguroUtil;

@Service
public class SeguroServiceImpl implements SeguroService {
	@Autowired
	private SeguroRepository seguroRepository;
	@Autowired
	private InmuebleRepository inmuebleRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private PropietarioRepository propietarioRepository;

	@Override
	public SeguroDTO guardar(SeguroDTO seguroDTO) {

		Optional<Inmueble> optInmueble = inmuebleRepository.findById(seguroDTO.getInmueble().getId());
		Optional<Pais> optPais = paisRepository.findById(seguroDTO.getPais().getId());
		Optional<Propietario> optPropietario = propietarioRepository.findById(seguroDTO.getPropietario().getId());

		seguroDTO.setInmueble(optInmueble.get());
		seguroDTO.setPais(optPais.get());
		seguroDTO.setPropietario(optPropietario.get());
		seguroDTO.setValor(SeguroUtil.getValorPrima(optInmueble.get().getValor()));
		Seguro seguro = convertirAEntidad(seguroDTO);
		seguroRepository.save(seguro);

		return convertirADominio(seguro);

	}

	@Override
	public SeguroDTO consultar(Long id) {
		return null;
	}

	@Override
	public List<SeguroDTO> listarPorPropietario(Long idPropietario) {
		return seguroRepository.findAll().stream().map(SeguroServiceImpl::convertirADominio)
				.collect(Collectors.toList());
	}

	@Override
	public List<SeguroDTO> listar() {
		return seguroRepository.findAll().stream().map(SeguroServiceImpl::convertirADominio)
				.collect(Collectors.toList());
	}

	public static SeguroDTO convertirADominio(Seguro seguro) {
		return new SeguroDTO(seguro.getId(), seguro.getInmueble(), seguro.getPropietario(), seguro.getPais(),
				seguro.getEstado(), seguro.getFecha(), seguro.getValor());
	}

	public static Seguro convertirAEntidad(SeguroDTO seguroDTO) {
		return new Seguro(seguroDTO.getId(), seguroDTO.getInmueble(), seguroDTO.getPropietario(), seguroDTO.getPais(),
				seguroDTO.getEstado(), seguroDTO.getFecha(), seguroDTO.getValor());
	}

}
