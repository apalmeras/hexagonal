package com.ceiba.servicio.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.dominio.ReclamacionDTO;
import com.ceiba.dominio.excepcion.RegistroNoExisteException;
import com.ceiba.entidad.Reclamacion;
import com.ceiba.respositorio.ReclamacionRepository;
import com.ceiba.servicio.ReclamacionService;
import com.ceiba.servicio.reglas.ValidarVideo;

@Service
public class ReclamacionImpl implements ReclamacionService{

	@Autowired
	private ReclamacionRepository repositoryReclamacion;
	@Autowired
	private ReclamacionService reclamacionService;
	
	@Override
	public ReclamacionDTO guardar(ReclamacionDTO reclamacionDTO) {
		new ValidarVideo(reclamacionService).verificar(reclamacionDTO.getRuta());
		Reclamacion reclamacion = convertirAEntidad(reclamacionDTO);
		this.repositoryReclamacion.save(reclamacion);
		
		return convertirADominio(reclamacion);
	}

	@Override
	public ReclamacionDTO editar(ReclamacionDTO reclamacionDTO) {
		// TODO Auto-generated method stub
		Reclamacion reclamacion = convertirAEntidad(reclamacionDTO);
		this.repositoryReclamacion.save(reclamacion);
		
		return convertirADominio(reclamacion);
	}

	@Override
	public List<ReclamacionDTO> listar() {
		return repositoryReclamacion.findAll().stream().map(ReclamacionImpl::convertirADominio)
				.collect(Collectors.toList());
	}

	@Override
	public void eliminar(Long id) {
		this.repositoryReclamacion.deleteById(id);
	}
	
	@Override
	public ReclamacionDTO buscar(Long id) {
		Optional<Reclamacion> optReclamacion = repositoryReclamacion.findById(id);
		if (optReclamacion.isPresent()) {
			return convertirADominio(optReclamacion.get());
		}
		throw new RegistroNoExisteException("Reclamación no encontrada");
	}
	
	public static ReclamacionDTO convertirADominio(Reclamacion reclamacion) {
		return new ReclamacionDTO(reclamacion.getId(), reclamacion.getIdSeguro(), reclamacion.getRuta(),reclamacion.getRespuesta());
	}

	public static Reclamacion convertirAEntidad(ReclamacionDTO reclamacionDTO) {
		return new Reclamacion(reclamacionDTO.getId(), reclamacionDTO.getIdSeguro(), reclamacionDTO.getRuta(),reclamacionDTO.getRespuesta());
	}

	


}
