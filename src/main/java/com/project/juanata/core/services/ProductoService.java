package com.project.juanata.core.services;

import java.util.List;

import com.project.juanata.core.model.dto.ItemDTO;
import com.project.juanata.core.model.dto.ProductoDTO;


public interface ProductoService {
	
	ProductoDTO obtenerProductoPorId(Integer productoId);
	
	ItemDTO obtenerItemPorNombreYCategoria(String nombreItem, Integer categoriaId);
	
	List<ProductoDTO> getProductosPorItemYCategoria(String nombreCategoria, String nombreItem);
	
}
