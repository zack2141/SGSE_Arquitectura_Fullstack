package com.example.SGSE.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Notificacion")
public class Notificacion {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idNotificacion")
	private Long idNotificacion;
	

	@ManyToOne()
	@JoinColumn(name = "Id_Usuario", referencedColumnName = "idUsuario")
	private Usuario usuario;
	
	@Column(name="Mensaje")
	private String mensaje;
	
	@Column(name="fecha")
	private LocalDateTime fecha;
	
	@Column(name="EstadoSolicitud")
	private String estadoSolicitud;

	public Notificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notificacion(Long idNotificacion, Usuario usuario, String mensaje, LocalDateTime fecha,
			String estadoSolicitud) {
		super();
		this.idNotificacion = idNotificacion;
		this.usuario = usuario;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.estadoSolicitud = estadoSolicitud;
	}

	public Long getIdNotificacion() {
		return idNotificacion;
	}

	public void setIdNotificacion(Long idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
	
	
	
	

}
