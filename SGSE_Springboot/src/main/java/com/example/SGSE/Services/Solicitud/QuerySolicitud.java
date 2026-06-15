package com.example.SGSE.Services.Solicitud;

import org.springframework.stereotype.Service;

import com.example.SGSE.Repositories.NotificacionRepository;
import com.example.SGSE.Repositories.SolicitudRepository;

@Service
public class QuerySolicitud {
	
	// instancia de repositorio

		private final SolicitudRepository SoliRep;
		
		
		public QuerySolicitud( SolicitudRepository soliRep) {
			super();
			this.SoliRep = soliRep;
			
		}
		
		public void lista_Solicitudes() {
			
		}

}
