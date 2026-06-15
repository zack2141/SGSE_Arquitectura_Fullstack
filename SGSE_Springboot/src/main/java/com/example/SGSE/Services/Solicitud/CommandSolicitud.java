package com.example.SGSE.Services.Solicitud;

import org.springframework.stereotype.Service;

import com.example.SGSE.Repositories.NotificacionRepository;
import com.example.SGSE.Repositories.SolicitudRepository;

@Service
public class CommandSolicitud {
	
	// instancia de repositorio
	
	private final NotificacionRepository notiRep;
	private final SolicitudRepository SoliRep;
	
	
	public CommandSolicitud(NotificacionRepository notiRep, SolicitudRepository soliRep) {
		super();
		this.notiRep = notiRep;
		SoliRep = soliRep;
		
	}
	
	public void crear_Solicitud() {
		
		
	}
	
	public void cambiar_Estado() {
		
	}
	
	

}
