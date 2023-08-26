package com.project.juanata.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.juanata.core.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query(value = "select count(usr) from Usuario usr where usr.username = :username or usr.correo = :correo")
	public int buscarCantidadUsuariosPorUsernameCorreo(@Param("username") String username, @Param("correo") String correo);

}
