package com.example.SGSE.Services.Usuario;

import org.springframework.stereotype.Service;

import com.example.SGSE.Repositories.UsuarioRepository;

@Service
public class CommandUsuario {

	private final UsuarioRepository UsuRep;

	public CommandUsuario(UsuarioRepository usuRep) {
		super();
		UsuRep = usuRep;
	}
	
	
	public void registrar_Usuario() {
		
	}
}
