package com.example.SGSE.Services.Usuario;

import org.springframework.stereotype.Service;

import com.example.SGSE.Models.Usuario;
import com.example.SGSE.Repositories.UsuarioRepository;

@Service
public class CommandUsuario {

	private final UsuarioRepository UsuRep;

	public CommandUsuario(UsuarioRepository usuRep) {
		super();
		UsuRep = usuRep;
	}
	
	
	public String registrar_Usuario(Usuario nuevo) {
		
		if(nuevo.getNombre().equals("")  || nuevo.getNombre().isEmpty()) {
			
			return "debe de haber un nombre";
		}
		
        if(nuevo.getCorreo().equals("")  || nuevo.getCorreo().isEmpty()) {
			
			return "debe de haber un correo";
		}
        
        if(nuevo.getRol().equals("")  || nuevo.getRol().isEmpty() ) {
        	
        	return "se debe de agregar información al campo de rol";
			
			
		}else if(!nuevo.getRol().toUpperCase().equals("SOLICITANTE")) {
    		
    		if(!nuevo.getRol().toUpperCase().equals("FUNCIONARIO")){
    			return "debe de ingresar un rol vaildo";
    		}
    		
    	}
        
        if( this.verfica_Cedula(nuevo.getIdusuario())) {
        	return "ya existe un usuario con el ID";
        }
        
        nuevo.setRol(nuevo.getRol().toUpperCase());
        
        
		UsuRep.save(nuevo);
		
		return "registro exitoso";
		
	}
	
	public boolean verfica_Cedula(Long id) {
		
		return UsuRep.findById(id).isPresent();
		
	}
}
