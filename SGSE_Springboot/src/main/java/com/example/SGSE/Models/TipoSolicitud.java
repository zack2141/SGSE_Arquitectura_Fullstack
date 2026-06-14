package com.example.SGSE.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TipoSolicitud")
public class TipoSolicitud {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idTipo")
	private Long idTipo;
	

	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name="TiempoEstimadoDias")
	private String tiempoestimadodias ;

	public TipoSolicitud() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoSolicitud(Long idTipo, String nombre, String descripcion, String tiempoestimadodias) {
		super();
		this.idTipo = idTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempoestimadodias = tiempoestimadodias;
	}

	public Long getIduTipo() {
		return idTipo;
	}

	public void setIduTipo(Long iduTipo) {
		this.idTipo = iduTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTiempoestimadodias() {
		return tiempoestimadodias;
	}

	public void setTiempoestimadodias(String tiempoestimadodias) {
		this.tiempoestimadodias = tiempoestimadodias;
	}
	
	

}
