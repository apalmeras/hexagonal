package com.ceiba.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.dominio.PropietarioDTO;
import com.ceiba.dominio.excepcion.RegistroNoExisteException;
import com.ceiba.entidad.Propietario;
import com.ceiba.respositorio.PropietarioRepository;
import com.ceiba.servicio.PropietarioService;
import com.ceiba.servicio.reglas.ValidarPropietario;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class PropietarioServiceImpl implements PropietarioService {
	@Autowired
	private PropietarioRepository propietarioRepository;
	@Autowired
	private PropietarioService propietarioService;
	
	@Override
	public PropietarioDTO guardar(PropietarioDTO propietarioDTO) {
		new ValidarPropietario(propietarioService).verificar(propietarioDTO.getCedula());
		Propietario propietario = convertirAEntidad(propietarioDTO);
		propietarioRepository.save(propietario);
		return convertirADominio(propietario);
	}
	
	@Override
	public PropietarioDTO editar(PropietarioDTO propietarioDTO) {
		Propietario propietario = convertirAEntidad(propietarioDTO);
		propietarioRepository.save(propietario);
		return convertirADominio(propietario);
	}
	
	@Override
	public List<PropietarioDTO> listar() {
		return propietarioRepository.findAll().stream().map(PropietarioServiceImpl::convertirADominio)
				.collect(Collectors.toList());
	}
	
	@Override
	public void eliminar(Long id) {
		this.propietarioRepository.deleteById(id);
	}
	
	@Override
	public PropietarioDTO buscarPorCedula(String cedula) {
		Propietario propietario = this.propietarioRepository.findByCedula(cedula);
		if(propietario!=null) {
			return convertirADominio(propietario);
		}else {
			return null;
		}
	}

	@Override
	public PropietarioDTO consultar(Long id) {
		Optional<Propietario> optPropietario = propietarioRepository.findById(id);
		if (optPropietario.isPresent()) {
			return convertirADominio(optPropietario.get());
		}
		throw new RegistroNoExisteException("Propietario no encontrado");
	}

	public static PropietarioDTO convertirADominio(Propietario propietario) {
		return new PropietarioDTO(propietario.getId(), propietario.getCedula(), propietario.getNombre());
	}

	public static Propietario convertirAEntidad(PropietarioDTO propietarioDTO) {
		return new Propietario(propietarioDTO.getId(), propietarioDTO.getCedula(), propietarioDTO.getNombre());
	}

	

	

	

	

	

}
