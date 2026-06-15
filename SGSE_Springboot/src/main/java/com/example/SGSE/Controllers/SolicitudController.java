package com.example.SGSE.Controllers;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SGSE.Models.Solicitud;
import com.example.SGSE.Models.TipoSolicitud;
import com.example.SGSE.Models.Usuario;
import com.example.SGSE.Services.Solicitud.CommandSolicitud;
import com.example.SGSE.Services.Solicitud.QuerySolicitud;
import com.example.SGSE.Services.TipoSolicitud.QueryTipoSolicitud;
import com.example.SGSE.Services.Usuario.CommandUsuario;
import com.example.SGSE.Services.Usuario.QueryUsuario;

@RestController
@RequestMapping("/Solicitud/")
@CrossOrigin(origins = "http://localhost:8080/")
public class SolicitudController {
	
	private final CommandSolicitud Csolicitud;
	private final QuerySolicitud Qsolicitud;
	private final QueryTipoSolicitud QTsolicitud;
	
	
	public SolicitudController(CommandSolicitud csolicitud, QuerySolicitud qsolicitud, QueryTipoSolicitud qTsolicitud) {
		super();
		Csolicitud = csolicitud;
		Qsolicitud = qsolicitud;
		QTsolicitud = qTsolicitud;
	}


	@PostMapping("/Crear_Solicitud")
	public String crear_Solicitud (
			@RequestParam Long idUsuario,
			@RequestParam Long idTipoSolicitud,
			@RequestParam String descripcion) {
		

		
		return Csolicitud.crear_Solicitud(idUsuario,idTipoSolicitud,descripcion);
	}
	
	
	@GetMapping("/Lista_Tipo_Solicitud")
	public List<TipoSolicitud> listar_tipo_solicitud () {
		
		return QTsolicitud.consultar_Lista_Tipo_Solicitud();
	}
	
	@GetMapping("/Lista_Solicitudes")
	public List<Solicitud> listar_solicitudes (
			@RequestParam String estado) {
		
		return Qsolicitud.lista_Solicitudes(estado);
	}
	
	@PostMapping("/Cambiar_estado")
	public String cambiar_estado( 
			@RequestParam String nuevoEstado,
			@RequestParam Long idSolicitud) {
		
		return Csolicitud.cambiar_Estado(nuevoEstado, idSolicitud);
		
	}
	
	
	
	
	
	
	
	
	

}
