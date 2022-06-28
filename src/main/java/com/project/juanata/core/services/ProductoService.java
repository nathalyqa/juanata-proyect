package com.project.juanata.core.services;

import java.util.List;

import com.project.juanata.core.model.Producto;


public interface ProductoService {
	
	List<Producto> getPijamasMujer();
	
	List<Producto> getPantuflasMujer();
	
	List<Producto> getPijamasHombre();
}
