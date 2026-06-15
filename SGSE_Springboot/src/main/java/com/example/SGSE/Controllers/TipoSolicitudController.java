package com.example.SGSE.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SGSE.Models.TipoSolicitud;
import com.example.SGSE.Models.Usuario;
import com.example.SGSE.Services.TipoSolicitud.CommandTipoSolicitud;

@RestController
@RequestMapping("/TipoSolicitud/")
@CrossOrigin(origins = "http://localhost:8080/")
public class TipoSolicitudController {
	
	private final CommandTipoSolicitud CTSolicitud;

	public TipoSolicitudController(CommandTipoSolicitud cTSolicitud) {
		super();
		CTSolicitud = cTSolicitud;
	}
	
	@PostMapping("/Crear_Tipo_Solicitud")
	public String registrar_Usuario(
			@RequestParam String nombre,
			@RequestParam String descripcion,
			@RequestParam String tiempoDias) {
		
		TipoSolicitud nuevo = new TipoSolicitud(nombre,descripcion,tiempoDias);
		
		return CTSolicitud.registrar_Tipo_Solicitud(nuevo);
	}

}
