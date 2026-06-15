package com.example.SGSE.Services.Solicitud;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.SGSE.Models.Solicitud;
import com.example.SGSE.Models.TipoSolicitud;
import com.example.SGSE.Models.Usuario;
import com.example.SGSE.Repositories.NotificacionRepository;
import com.example.SGSE.Repositories.SolicitudRepository;
import com.example.SGSE.Services.TipoSolicitud.QueryTipoSolicitud;
import com.example.SGSE.Services.Usuario.QueryUsuario;

@Service
public class CommandSolicitud {
	
	// instancia de repositorio
	
	private final NotificacionRepository notiRep;
	private final SolicitudRepository SoliRep;
	private final QueryUsuario QUsuario;
	private final QueryTipoSolicitud QTsolicitud;
	
	
	

	public CommandSolicitud(NotificacionRepository notiRep, SolicitudRepository soliRep, QueryUsuario qUsuario,
			QueryTipoSolicitud qTsolicitud) {
		super();
		this.notiRep = notiRep;
		SoliRep = soliRep;
		QUsuario = qUsuario;
		QTsolicitud = qTsolicitud;
	}

	public String crear_Solicitud(Long idUsuario, Long idTipoSolicitud, String descripcion) {
		
		
		Usuario usuario = QUsuario.obtener_Usuario(idUsuario); 
		
		TipoSolicitud tipoSolicitud = QTsolicitud.obtener_Tipo_Solicitud(idTipoSolicitud);
		
		if( usuario == null) {
			return "el usuario no existe";
			
		}else if(tipoSolicitud == null) {
			
			return "el id de Tipo de solicitud no correponde a la base de datos";
			
		}
		
		
		if(descripcion.equals("") || descripcion.isEmpty()) {
			return "error con la descripcion, se debe de llenar el campo";
		}
		
		
		Solicitud nueva = new Solicitud(usuario, tipoSolicitud, descripcion, new Date(), "CREADA" );
		
		
		SoliRep.save(nueva);
		
		return "Solicitud creada exitosamente";
		
		
	}
	
	public void cambiar_Estado() {
		
	}
	
	

}
