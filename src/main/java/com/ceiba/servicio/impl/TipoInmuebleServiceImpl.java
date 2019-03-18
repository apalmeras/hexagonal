package com.ceiba.servicio.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.dominio.TipoInmuebleDTO;
import com.ceiba.dominio.excepcion.RegistroNoExisteException;
import com.ceiba.entidad.TipoInmueble;
import com.ceiba.respositorio.TipoInmuebleRepository;
import com.ceiba.servicio.TipoInmuebleService;

@Service
public class TipoInmuebleServiceImpl implements TipoInmuebleService {
	@Autowired
	private TipoInmuebleRepository tipoInmuebleRepository;
	

	@Override
	public TipoInmuebleDTO guardar(TipoInmuebleDTO tipoInmuebleDTO) {
		TipoInmueble tipoInmueble = convertirAEntidad(tipoInmuebleDTO);
		tipoInmuebleRepository.save(tipoInmueble);
		return convertirADominio(tipoInmueble);
	}
	
	@Override
	public TipoInmuebleDTO editar(TipoInmuebleDTO tipoInmuebleDTO) {
		TipoInmueble tipoInmueble = convertirAEntidad(tipoInmuebleDTO);
		tipoInmuebleRepository.save(tipoInmueble);
		return convertirADominio(tipoInmueble);
	}

	@Override
	public TipoInmuebleDTO consultar(Long id) {
		Optional<TipoInmueble> optTipoInmbueble = tipoInmuebleRepository.findById(id);
		if (optTipoInmbueble.isPresent()) {
			return convertirADominio(optTipoInmbueble.get());
		}
		throw new RegistroNoExisteException("Tipo Inmueble no encontrado");
	}
	
	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.tipoInmuebleRepository.deleteById(id);
	}

	@Override
	public List<TipoInmuebleDTO> listar() {
		return tipoInmuebleRepository.findAll().stream().map(TipoInmuebleServiceImpl::convertirADominio)
				.collect(Collectors.toList());
	}

	public static TipoInmuebleDTO convertirADominio(TipoInmueble tipoInmueble) {
		return new TipoInmuebleDTO(tipoInmueble.getId(), tipoInmueble.getNombre());
	}

	public static TipoInmueble convertirAEntidad(TipoInmuebleDTO tipoInmuebleDTO) {
		return new TipoInmueble(tipoInmuebleDTO.getId(), tipoInmuebleDTO.getNombre());
	}

	

}
