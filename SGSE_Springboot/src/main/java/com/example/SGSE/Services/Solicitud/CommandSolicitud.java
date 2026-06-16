package com.example.SGSE.Services.Solicitud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SGSE.Models.Solicitud;
import com.example.SGSE.Models.TipoSolicitud;
import com.example.SGSE.Models.Usuario;
import com.example.SGSE.Orbserver.Notificacion.ObserverNotificacionCorreo;
import com.example.SGSE.Orbserver.Notificacion.ObserverNotificacionWhatsapp;
import com.example.SGSE.Repositories.NotificacionRepository;
import com.example.SGSE.Repositories.ObserverNotificacionRepository;
import com.example.SGSE.Repositories.SolicitudRepository;
import com.example.SGSE.Services.Notificacion.CommandNotificación;
import com.example.SGSE.Services.TipoSolicitud.QueryTipoSolicitud;
import com.example.SGSE.Services.Usuario.QueryUsuario;

@Service
public class CommandSolicitud {
	
	// instancia de repositorio
	
	private final SolicitudRepository SoliRep;
	private final QueryUsuario QUsuario;
	private final QueryTipoSolicitud QTsolicitud;
	private final QuerySolicitud Qsolicitud;
	private final CommandNotificación CNotificacion;
	
	/*--------------------------------------------------------------------------------------------------------------------------------------*/

	public CommandSolicitud(SolicitudRepository soliRep, QueryUsuario qUsuario, QueryTipoSolicitud qTsolicitud,
			QuerySolicitud qsolicitud, CommandNotificación cNotificacion) {
		super();
		SoliRep = soliRep;
		QUsuario = qUsuario;
		QTsolicitud = qTsolicitud;
		Qsolicitud = qsolicitud;
		CNotificacion = cNotificacion;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------*/

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
	
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	
	public void actualizar_solicitd (Solicitud solicitud) {
		
		SoliRep.save(solicitud);
		
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	
	public String cambiar_Estado(String nuevoEstado, Long id) {

		
		Solicitud solicitud = Qsolicitud.obtener_Solicitud(id);
		
		if(solicitud == null){
			return "Error al encontrar la solicitud";
		}
		
		if(nuevoEstado.equals("") || nuevoEstado.isEmpty()) {
			return "Error, se debe de llenar el campo de Estado";
		}
		
		if( nuevoEstado.toUpperCase().equals("CREADA") || nuevoEstado.toUpperCase().equals("EN_REVISION") || nuevoEstado.toUpperCase().equals("APROBADA") || nuevoEstado.toUpperCase().equals("RECHAZADA") || nuevoEstado.toUpperCase().equals("CERRADA") ) {
			
		}else {
			
			return "Error, se ingresó un estado invalido";
			
		}
		
		solicitud.setEstado(nuevoEstado.toUpperCase());
		
		this.actualizar_solicitd(solicitud);
		
		String notificacion = this.Notificar(nuevoEstado, solicitud);
		
		return "cambio de estado exitoso \n" + notificacion;
		
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	
	private String Notificar (String estado, Solicitud solicitud) {
		
		List <ObserverNotificacionRepository> listaObservers = this.ObserversNotificacion();
		
		return CNotificacion.Obtener_Notificación(estado, solicitud,listaObservers); 
		
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	
	private List<ObserverNotificacionRepository> ObserversNotificacion() {
		
		List <ObserverNotificacionRepository> listaObservers = new ArrayList<>(); 
		
		listaObservers.add(new ObserverNotificacionCorreo());
		listaObservers.add( new ObserverNotificacionWhatsapp());
		
		return listaObservers;
		
	}
	
	

}
