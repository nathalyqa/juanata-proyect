package com.project.juanata.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.juanata.core.entity.Categoria;
import com.project.juanata.core.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	List<Item> findByCategoria(Categoria categoria);
	
	@Query(value = "select i from Item i where i.nombre = :nombre and i.categoria.id = :categoriaId")
	Item findByNombreAndCategoria(@Param("nombre") String nombreItem, @Param("categoriaId") Integer categoriaId);
	
	@Query(value = "select i.id from item i where i.id not in (:idsItemsExcepcion) order by rand() limit 2", nativeQuery = true)
	List<Integer> obtenerIdItemsConExcepcion(@Param("idsItemsExcepcion") List<Integer> idsItemsExcepcion);
	
	@Query(value = "select i from Item i where i.id in (:idsItemsBuscar)")
	List<Item> obetenerItemsPorListaDeIds(@Param("idsItemsBuscar") List<Integer> idsItemsBuscar);

}
