package com.project.juanata.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.juanata.core.model.Item;
import com.project.juanata.core.util.Constantes;

@Service
public class CategoriasServiceImpl implements CategoriasService{

	@Override
	public List<Item> getItemsMujer() {
		
		List<Item> items = new ArrayList<Item>();
		
		items.add(new Item(0L,"Pijamas","/img/categorias/mujeres/_MG_8109.jpg","/producto/pijamas/mujer"));
		items.add(new Item(1L,"Pantuflas","/img/categorias/mujeres/_MG_8109.jpg","/producto/pijamas/mujer"));
		items.add(new Item(1L,"Bodys","/img/categorias/mujeres/_MG_8109.jpg","/producto/pijamas/mujer"));
		items.add(new Item(1L,"Chaquetas","/img/categorias/mujeres/_MG_8109.jpg","/producto/pijamas/mujer"));
		
		return items;
	}

	@Override
	public List<Item> getItemsHombre() {
		
		List<Item> items = new ArrayList<Item>();
		
		items.add(new Item(0L,"Pijamas","/img/categorias/hombres/productos/productosHombre.jpg","/producto/pijamas/hombre"));
		items.add(new Item(1L,"Pantuflas","/img/categorias/hombres/productos/productosHombre.jpg","/producto/pijamas/hombre"));
		
		return items;
	}

}
