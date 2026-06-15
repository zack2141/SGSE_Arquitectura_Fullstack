package com.example.SGSE.Services.Solicitud;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SGSE.Models.Solicitud;
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
		
		public List<Solicitud> lista_Solicitudes(String estado) {
			
			return SoliRep.findByEstado(estado);
			
		}
		
		public Solicitud obtener_Solicitud (Long id) {
			return SoliRep.findById(id).orElse(null);
		}

}
