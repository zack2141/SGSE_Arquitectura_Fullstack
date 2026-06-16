package com.example.SGSE.Models;

import java.time.LocalDateTime;
import java.util.Date;

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
	@JoinColumn(name = "Id_solicitud", referencedColumnName = "idSolicitud")
	private Solicitud solicitud;
	
	@Column(name="Mensaje")
	private String mensaje;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="EstadoSolicitud")
	private String estadoSolicitud;

	public Notificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Notificacion( Solicitud solicitud, String mensaje, Date fecha,
			String estadoSolicitud) {
		super();
		this.solicitud = solicitud;
		this.mensaje = mensaje;
		this.fecha = fecha  ;
		this.estadoSolicitud = estadoSolicitud;
	}



	public Long getIdNotificacion() {
		return idNotificacion;
	}

	public void setIdNotificacion(Long idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

	public Solicitud getUsuario() {
		return solicitud;
	}

	public void setUsuario(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
	
	
	
	

}
