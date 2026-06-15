package com.example.SGSE.Services.Notificacion;

import org.springframework.stereotype.Service;

import com.example.SGSE.Repositories.NotificacionRepository;

@Service
public class CommandNotificación {
	
	private final NotificacionRepository NotiRep;

	public CommandNotificación(NotificacionRepository notiRep) {
		super();
		NotiRep = notiRep;
	}
	
	public void generar_Notificacion() {
		
	}

}
