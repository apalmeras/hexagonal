package com.ceiba.servicio.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.dominio.InmuebleDTO;
import com.ceiba.dominio.excepcion.RegistroNoExisteException;
import com.ceiba.entidad.Inmueble;
import com.ceiba.respositorio.InmuebleRepository;
import com.ceiba.servicio.EstratoService;
import com.ceiba.servicio.InmuebleService;
import com.ceiba.servicio.reglas.ValidarEstrato;
@Service
public class InmuebleServiceImpl implements InmuebleService {
	@Autowired
	private InmuebleRepository inmuebleRepository;
	@Autowired
	private EstratoService estratoService;

	@Override
	public InmuebleDTO guardar(InmuebleDTO inmuebleDTO) {
		new ValidarEstrato(estratoService).verificar(inmuebleDTO.getDireccion(), inmuebleDTO.getEstrato());;
		Inmueble inmueble = convertirAEntidad(inmuebleDTO);
		inmuebleRepository.save(inmueble);
		return convertirADominio(inmueble);
	}

	@Override
	public InmuebleDTO consultar(Long id) {
		Optional<Inmueble> optPropietario = inmuebleRepository.findById(id);
		if (optPropietario.isPresent()) {
			return convertirADominio(optPropietario.get());
		}
		throw new RegistroNoExisteException("Propietario no encontrado");
	}

	@Override
	public List<InmuebleDTO> listar() {
		return inmuebleRepository.findAll().stream().map(InmuebleServiceImpl::convertirADominio)
				.collect(Collectors.toList());
	}

	public static InmuebleDTO convertirADominio(Inmueble inmueble) {
		return new InmuebleDTO(inmueble.getId(), inmueble.getTipo(), inmueble.getDireccion(), inmueble.getMetraje(),
				inmueble.getEstrato(), inmueble.getValor());
	}

	public static Inmueble convertirAEntidad(InmuebleDTO inmuebleDTO) {
		return new Inmueble(inmuebleDTO.getId(), inmuebleDTO.getTipo(), inmuebleDTO.getDireccion(),
				inmuebleDTO.getMetraje(), inmuebleDTO.getEstrato(), inmuebleDTO.getValor());
	}

}
