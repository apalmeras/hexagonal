package com.ceiba.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.dominio.EstratoDTO;
import com.ceiba.entidad.Estrato;
import com.ceiba.respositorio.EstratoRepository;
import com.ceiba.servicio.EstratoService;

@Service
public class EstratoServiceImpl implements EstratoService {
	@Autowired
	private EstratoRepository estratoRepository;

	@Override
	public Integer getCalificacionPorDireccion(String direccion) {
		return estratoRepository.findByDireccion(direccion).getClasificacion();
	}

	@Override
	public EstratoDTO guardar(EstratoDTO estratoDTO) {
		Estrato estrato = convertirAEntidad(estratoDTO);
		estratoRepository.save(estrato);
		return convertirADominio(estrato);

	}

	public static EstratoDTO convertirADominio(Estrato estrato) {
		return new EstratoDTO(estrato.getId(), estrato.getClasificacion(), estrato.getDireccion());
	}

	public static Estrato convertirAEntidad(EstratoDTO estratoDTO) {
		return new Estrato(estratoDTO.getId(), estratoDTO.getClasificacion(), estratoDTO.getDireccion());

	}

}
