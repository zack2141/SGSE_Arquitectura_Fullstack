package com.example.SGSE.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SGSE.Models.Solicitud;

public interface SolicitudRepository  extends JpaRepository<Solicitud,Long>{
	
	public List<Solicitud> findByEstado(String estado);
	

}
