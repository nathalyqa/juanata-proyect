package com.project.juanata.core.services;

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
	public void crearUsuario(UsuarioDTO usuarioDTO) {
			
		
		Role role = roleRepository.buscarRolePorPerfil(Constantes.ROLE_CLENTE);
		
		Usuario usuario = null;
		
		if(role != null) {
			usuario = new Usuario(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getUsername(), usuarioDTO.getContrasenna(), usuarioDTO.getCorreo(), Boolean.TRUE, role);
			
			usuarioRepositorio.save(usuario);
		}
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
