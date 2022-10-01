package com.project.juanata.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.juanata.core.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
	List<Categoria> findByNombre(String nombre);
	
	@Query(value = "select c.id from Categoria c where c.nombre = :nombreCategoria")
	Integer obtenerIdCategoriaPorNombre(@Param("nombreCategoria") String nombreCategoria);

}
