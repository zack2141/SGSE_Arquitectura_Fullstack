package com.example.SGSE.Services.TipoSolicitud;

import org.springframework.stereotype.Service;

import com.example.SGSE.Repositories.TipoSolicitudRepository;

@Service
public class CommandTipoSolicitud {

	private final TipoSolicitudRepository tsRepository;

	public CommandTipoSolicitud(TipoSolicitudRepository tsRepository) {
		super();
		this.tsRepository = tsRepository;
	}
	
	public void registrar_Tipo_Solicitud() {
		
	}
}
