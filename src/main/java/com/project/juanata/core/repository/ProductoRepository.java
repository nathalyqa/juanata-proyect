package com.project.juanata.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.juanata.core.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	@Query(value = "select p from Producto p where p.categoria.id = :categoriaId and p.item.id = :itemId")
	List<Producto> obtenerProductosPorIdItemYIdCategoria(@Param("itemId") Integer itemId, @Param("categoriaId") Integer categoriaId);
	
	
	@Query(value = "select p from Producto p where p.id = :idProducto")
	Producto obtenerProductoPorId(@Param("idProducto") Integer productoId);
	

}
