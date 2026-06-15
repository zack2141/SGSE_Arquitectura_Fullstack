package com.example.SGSE.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SGSE.Services.Reporte.QueryReporte;

@RestController
@RequestMapping("/Reporte/")
@CrossOrigin(origins = "http://localhost:8080/")
public class ReporteController {
	
	private final QueryReporte QReporte;

	public ReporteController(QueryReporte qReporte) {
		super();
		QReporte = qReporte;
	}
	
	@GetMapping("/Generar_Reporte")
	public String generar_Reporte() {
		
		return QReporte.generar_Reporte();
		
	}
	
	

}
