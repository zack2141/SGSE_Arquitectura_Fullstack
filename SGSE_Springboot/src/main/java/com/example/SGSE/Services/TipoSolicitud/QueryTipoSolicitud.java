package com.example.SGSE.Services.TipoSolicitud;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SGSE.Models.TipoSolicitud;
import com.example.SGSE.Repositories.TipoSolicitudRepository;

@Service
public class QueryTipoSolicitud {
	
	private final TipoSolicitudRepository tsRepository;

	public QueryTipoSolicitud(TipoSolicitudRepository tsRepository) {
		super();
		this.tsRepository = tsRepository;
	}
	
	public List<TipoSolicitud> consultar_Lista_Tipo_Solicitud (){
		
		return tsRepository.findAll();
	}
	
	public TipoSolicitud obtener_Tipo_Solicitud(Long id) {
		return tsRepository.findById(id).orElse(null);
	}

}
