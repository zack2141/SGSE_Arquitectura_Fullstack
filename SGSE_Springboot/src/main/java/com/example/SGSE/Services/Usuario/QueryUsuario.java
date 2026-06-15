package com.example.SGSE.Services.Usuario;

import org.springframework.stereotype.Service;

import com.example.SGSE.Models.Usuario;
import com.example.SGSE.Repositories.UsuarioRepository;

@Service
public class QueryUsuario {
	
	private final UsuarioRepository UsuRep;

	public QueryUsuario(UsuarioRepository usuRep) {
		super();
		UsuRep = usuRep;
	}
	
	
	public Usuario obtener_Usuario(Long id) {
		
		return UsuRep.findById(id).orElse(null);
		
	}

}
