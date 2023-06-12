package com.project.juanata.core.model.dto;

import com.project.juanata.core.entity.Role;

public class UsuarioDTO {
	
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private String username;
	
	private String contrasenna;
	
	private String correo;
	
	private Boolean activo;
	
	private Role role;
	
	

	public UsuarioDTO(Long id, String nombre, String apellido, String username, String contrasenna, String correo,
			Boolean activo, Role role) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.contrasenna = contrasenna;
		this.correo = correo;
		this.activo = activo;
		this.role = role;
	}
	
	public UsuarioDTO(String nombre, String apellido, String username, String contrasenna, String correo,
			Boolean activo, Role role) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.contrasenna = contrasenna;
		this.correo = correo;
		this.activo = activo;
		this.role = role;
	}

	public UsuarioDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
