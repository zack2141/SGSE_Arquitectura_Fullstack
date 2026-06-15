package com.example.SGSE.Models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Solicitud")
public class Solicitud {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idSolicitud")
	private Long idSolicitud;
	

	@ManyToOne()
	@JoinColumn(name = "Id_Usuario", referencedColumnName = "idUsuario")
	@Column(name="Usuario")
	private Usuario usuario;
	
	@ManyToOne()
	@JoinColumn(name = "Id_TipoSolicitud", referencedColumnName = "idTipo")
	@Column(name="TipoSolicitud")
	private TipoSolicitud tipoSolicitud;
	
	@Column(name="Descripcion")
	private String Descripción;
	
	@Column(name="FechaCreacion")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaCreacion;
	
	@Column(name="Estado")
	private String estado;

	public Solicitud() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Solicitud(Long idSolicitud, Usuario usuario, TipoSolicitud tipoSolicitud, String descripción,
			Date fechaCreacion, String estado) {
		super();
		this.idSolicitud = idSolicitud;
		this.usuario = usuario;
		this.tipoSolicitud = tipoSolicitud;
		Descripción = descripción;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getDescripción() {
		return Descripción;
	}

	public void setDescripción(String descripción) {
		Descripción = descripción;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	

}
