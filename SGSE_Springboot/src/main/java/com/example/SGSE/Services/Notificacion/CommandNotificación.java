package com.example.SGSE.Services.Notificacion;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SGSE.Models.Notificacion;
import com.example.SGSE.Models.Solicitud;
import com.example.SGSE.Repositories.NotificacionRepository;
import com.example.SGSE.Repositories.ObserverNotificacionRepository;

@Service
public class CommandNotificación {
	
	private final NotificacionRepository NotiRep;

	public CommandNotificación(NotificacionRepository notiRep) {
		super();
		NotiRep = notiRep;
	}
	
	public String generar_Notificacion(List<ObserverNotificacionRepository> Observers) {
		
		String mensaje ="";
		
		for(ObserverNotificacionRepository observer : Observers) {
			
			mensaje+= observer.notificar() +"\n";
		}
		return mensaje;
		
	}
	
	public String almacenar_Notificación(String estado, Solicitud solicitud) {
		
		Notificacion nueva = new Notificacion(solicitud,"Cambio de estado en la solicitud",new Date(),estado);
		
		NotiRep.save(nueva);
		
		return "Notificación almacenada";
	}
	
	public String Obtener_Notificación(String estado, Solicitud solicitud,  List<ObserverNotificacionRepository> Observers) {
		
		String notificaciones = this.generar_Notificacion(Observers);
		
		String almacenado = this.almacenar_Notificación(estado, solicitud);
		
		String mensajeFinal = 
				"NOTIFICACION"
				+"---------------------------- \n"
				+notificaciones
				+"---------------------------- \n"
				+almacenado + "\n";
		
		return mensajeFinal;
		
	}

}
