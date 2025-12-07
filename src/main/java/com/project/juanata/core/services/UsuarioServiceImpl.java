package com.project.juanata.core.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.juanata.core.entity.Role;
import com.project.juanata.core.entity.Usuario;
import com.project.juanata.core.model.dto.UsuarioDTO;
import com.project.juanata.core.repository.RoleRepository;
import com.project.juanata.core.repository.UsuarioRepository;
import com.project.juanata.core.util.Constantes;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void crearUsuario(UsuarioDTO usuarioDTO) throws SQLException {
			
		Role role = roleRepository.buscarRolePorPerfil(Constantes.ROLE_CLENTE);
		
		Usuario usuario = null;
		
		if(role != null) {
			String passwordEncriptada = passwordEncoder.encode(usuarioDTO.getContrasenna());
			usuario = new Usuario(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getUsername(), passwordEncriptada, usuarioDTO.getCorreo(), Boolean.TRUE, role);
			
			if(!existeUsuario(usuarioDTO)) {				
				usuarioRepositorio.save(usuario);
			}else {
				throw new SQLException("El usuario no se pudo crear satisfactoriamente, porque ya existe uno con el mismo nombre de usuario o correo.");
			}
		}
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.buscarPorUsername(username);
		
		if (usuario == null || usuario.getActivo() == null || !usuario.getActivo()) {
			throw new UsernameNotFoundException("Usuario no encontrado o inactivo");
		}
		
		Role role = usuario.getRole();
		String perfil = role != null ? role.getPerfil() : null;
		
		if (perfil == null) {
			throw new UsernameNotFoundException("Usuario sin rol asociado");
		}
		
		GrantedAuthority authority = new SimpleGrantedAuthority(perfil);
		
		return new User(usuario.getUsername(), usuario.getContrasenna(), java.util.Collections.singleton(authority));
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
