package com.example.SGSE.Services.TipoSolicitud;

import org.springframework.stereotype.Service;

import com.example.SGSE.Models.TipoSolicitud;
import com.example.SGSE.Repositories.TipoSolicitudRepository;

@Service
public class CommandTipoSolicitud {

	private final TipoSolicitudRepository tsRepository;

	public CommandTipoSolicitud(TipoSolicitudRepository tsRepository) {
		super();
		this.tsRepository = tsRepository;
	}
	
	public String registrar_Tipo_Solicitud(TipoSolicitud nuevo) {
		
		if(nuevo.getNombre().equals("") || nuevo.getNombre().isEmpty()) {
			return "Se debe de registrar un nombre";
		}
		
		if(nuevo.getDescripcion().equals("") || nuevo.getDescripcion().isEmpty()) {
			return "Se debe de registrar una descripcion";
		}
		
		if(nuevo.getTiempoestimadodias().equals("") || nuevo.getTiempoestimadodias().isEmpty()) {
			return "Se debe de registrar un tiempo estimado de dias";
		}
		
		
		
		tsRepository.save(nuevo);
		
		return "Tipo de Solicitud Registrada";
		
	}
}
