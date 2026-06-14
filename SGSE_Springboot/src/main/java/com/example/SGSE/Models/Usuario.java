package com.example.SGSE.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@Column(name="idUsuario")
	private Long idusuario;
	
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name = "Correo")
	private String correo;
	
	@Column(name = "Rol")
	private String rol;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Long idusuario, String nombre, String correo, String rol) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.correo = correo;
		this.rol = rol;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	

}
