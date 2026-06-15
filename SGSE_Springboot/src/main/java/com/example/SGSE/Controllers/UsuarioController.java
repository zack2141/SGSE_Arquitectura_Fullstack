package com.example.SGSE.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SGSE.Models.Usuario;
import com.example.SGSE.Services.Usuario.CommandUsuario;

@RestController
@RequestMapping("/Usuario/")
@CrossOrigin(origins = "http://localhost:8080/")
public class UsuarioController {
	
	private final CommandUsuario Cusuario;

	public UsuarioController(CommandUsuario cusuario) {
		super();
		Cusuario = cusuario;
	}
	
	@PostMapping("/registrar_Usuario")
	public String registrar_Usuario(
			@RequestParam Long id,
			@RequestParam String nombre,
			@RequestParam String correo,
			@RequestParam String rol) {
		
		Usuario nuevo = new Usuario(id,nombre,correo,rol);
		
		return Cusuario.registrar_Usuario(nuevo);
	}

}
