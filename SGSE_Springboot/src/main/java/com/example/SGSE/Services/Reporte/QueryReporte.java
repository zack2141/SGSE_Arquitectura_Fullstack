package com.example.SGSE.Services.Reporte;

import org.springframework.stereotype.Service;

import com.example.SGSE.Repositories.SolicitudRepository;

@Service
public class QueryReporte {
	
	private final SolicitudRepository SoliRep;

	public QueryReporte(SolicitudRepository soliRep) {
		super();
		SoliRep = soliRep;
	}
	
	

}
