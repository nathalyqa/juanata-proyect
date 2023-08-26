package com.project.juanata.core.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.juanata.core.entity.Role;
import com.project.juanata.core.entity.Usuario;
import com.project.juanata.core.model.dto.UsuarioDTO;
import com.project.juanata.core.repository.RoleRepository;
import com.project.juanata.core.repository.UsuarioRepository;
import com.project.juanata.core.util.Constantes;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void crearUsuario(UsuarioDTO usuarioDTO) throws SQLException {
			
		
		Role role = roleRepository.buscarRolePorPerfil(Constantes.ROLE_CLENTE);
		
		Usuario usuario = null;
		
		if(role != null) {
			usuario = new Usuario(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getUsername(), usuarioDTO.getContrasenna(), usuarioDTO.getCorreo(), Boolean.TRUE, role);
			
			if(!existeUsuario(usuarioDTO)) {				
				usuarioRepositorio.save(usuario);
			}else {
				throw new SQLException("El usuario no se pudo crear satisfactoriamente, porque ya existe uno con el mismo nombre de usuario o correo.");
			}
		}
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Boolean existeUsuario(UsuarioDTO usuarioDTO) {
		
		int cantidadUsuario = usuarioRepositorio.buscarCantidadUsuariosPorUsernameCorreo(usuarioDTO.getUsername(), usuarioDTO.getCorreo());
		
		if(cantidadUsuario > 0) {
			return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}
		
	}

}
