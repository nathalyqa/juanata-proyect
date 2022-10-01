package com.project.juanata.core.services;

import java.util.List;

import com.project.juanata.core.model.dto.ItemDTO;

public interface CategoriasService {
	
	public List<ItemDTO> getItemsMujer();
	
	public List<ItemDTO> getItemsHombre();
	
	List<ItemDTO> get2ItemsAleatorios(List<Integer> itemsIdsNoRetornable);
	
	Integer obtenerIdCategoriaPorNombre(String nombreCategoria);
}
