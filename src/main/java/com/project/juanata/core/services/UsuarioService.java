package com.project.juanata.core.services;

import java.sql.SQLException;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.juanata.core.model.dto.UsuarioDTO;

public interface UsuarioService extends UserDetailsService{
	
	public void crearUsuario(UsuarioDTO usuarioDTO) throws SQLException;

}
