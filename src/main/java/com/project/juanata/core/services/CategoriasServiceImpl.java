package com.project.juanata.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.juanata.core.entity.Categoria;
import com.project.juanata.core.entity.Item;
import com.project.juanata.core.model.dto.ItemDTO;
import com.project.juanata.core.repository.CategoriaRepository;
import com.project.juanata.core.repository.ItemRepository;

@Service
public class CategoriasServiceImpl implements CategoriasService{
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	private static final String NOMBRE_CATEGORIA_MUJER = "MUJER";
	private static final String NOMBRE_CATEGORIA_HOMBRE = "HOMBRE";

	@Override
	public List<ItemDTO> getItemsMujer() {
		
		List<ItemDTO> items = new ArrayList<ItemDTO>();
		
		Categoria categoria = new Categoria();
		categoria = categoriaRepository.findByNombre(NOMBRE_CATEGORIA_MUJER).get(0);
		
		Iterable<Item> itemsBD = itemRepository.findByCategoria(categoria);
		
		for (Item item : itemsBD) {			
			items.add(transformarObjectItemADTO(item));
		}
		
		return items;
	}

	@Override
	public List<ItemDTO> getItemsHombre() {
		
		List<ItemDTO> items = new ArrayList<ItemDTO>();
		
		Categoria categoria = new Categoria();
		categoria = categoriaRepository.findByNombre(NOMBRE_CATEGORIA_HOMBRE).get(0);
		
		Iterable<Item> itemsBD = itemRepository.findByCategoria(categoria);
		
		for (Item item : itemsBD) {			
			items.add(transformarObjectItemADTO(item));
		}
		
		return items;
	}
	
	@Override
	public List<ItemDTO> get2ItemsAleatorios(List<Integer> itemsIdsNoRetornable){
		
		List<Integer> itemsId = itemRepository.obtenerIdItemsConExcepcion(itemsIdsNoRetornable);
		
		List<Item> items = itemRepository.obetenerItemsPorListaDeIds(itemsId);
		
		List<ItemDTO> itemsDTO = new ArrayList<>();
		for (Item item : items) {
			
			itemsDTO.add(transformarObjectItemADTO(item));
		}
		
		return itemsDTO;
		
	}
	
	@Override
	public Integer obtenerIdCategoriaPorNombre(String nombreCategoria) {
		
		Integer idCategoria = categoriaRepository.obtenerIdCategoriaPorNombre(nombreCategoria);
		
		return idCategoria;
		
	}
	
	private ItemDTO transformarObjectItemADTO(Item item){
		
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setId(item.getId());
		itemDTO.setLink(item.getLink());
		itemDTO.setNombreItem(item.getNombre());
		itemDTO.setRutaFoto(item.getRutaFoto());
		
		return itemDTO;
		
	}

}
