package com.example.SGSE.Orbserver.Notificacion;

import com.example.SGSE.Repositories.ObserverNotificacionRepository;

public class ObserverNotificacionCorreo implements ObserverNotificacionRepository {

	@Override
	public String notificar() {
		
		return "Notificacion correcta al correo";
	}
	
	

}
