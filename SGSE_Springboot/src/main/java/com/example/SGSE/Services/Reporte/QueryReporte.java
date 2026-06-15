package com.example.SGSE.Services.Reporte;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SGSE.Models.Solicitud;
import com.example.SGSE.Repositories.SolicitudRepository;

@Service
public class QueryReporte {
	
	private final SolicitudRepository SoliRep;

	public QueryReporte(SolicitudRepository soliRep) {
		super();
		SoliRep = soliRep;
	}
	
	public String generar_Reporte() {
		
		String reporte ="";
		
		List<Solicitud> Solicitudes = SoliRep.findAll();
		
		if(Solicitudes.size() <= 0) {
			
			return "No se encontraron solicitude spara generar un reporte";
		}
		
		reporte+="---------------------------------------- \n"
				+ "Reporte de solicitudes \n"
				+ "--------------------------------------- \n"
				+ "Cantidad de solicitudes registradas = " + Solicitudes.size()+" \n"
				+ "-------------------------------------- \n"
				+ "Solicitudes registradas = \n";
		
		
		
		
		for(Solicitud solicitud : Solicitudes) {
			
			
			reporte+=" \n "
					+"........................................................................................ \n "
					+" ID Solicitud = " + solicitud.getIdSolicitud() + "\n"
					+" Tipo de Solicitud = " + solicitud.getTipoSolicitud().getNombre() + "\n"
					+" Tiempo de resolución = " + solicitud.getTipoSolicitud().getTiempoestimadodias() + "\n"
					+" ID del solicitante = " + solicitud.getUsuario().getIdusuario() + "\n"
				    +" Fecha de creación = " + solicitud.getFechaCreacion() + "\n"
				    +" Estado= " + solicitud.getEstado() + "\n";
			
			
		}
		
		
		return reporte;
	}
	
	

}
