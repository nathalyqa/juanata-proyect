package com.project.juanata.core.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.juanata.core.entity.Categoria;
import com.project.juanata.core.entity.Color;
import com.project.juanata.core.entity.Item;
import com.project.juanata.core.entity.Linea;
import com.project.juanata.core.entity.Producto;
import com.project.juanata.core.entity.Talla;
import com.project.juanata.core.model.dto.ColorDTO;
import com.project.juanata.core.model.dto.ItemDTO;
import com.project.juanata.core.model.dto.LineaDTO;
import com.project.juanata.core.model.dto.ProductoDTO;
import com.project.juanata.core.model.dto.TallaDTO;
import com.project.juanata.core.repository.CategoriaRepository;
import com.project.juanata.core.repository.ItemRepository;
import com.project.juanata.core.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public List<ProductoDTO> getProductosPorItemYCategoria(String nombreCategoria, String nombreItem){
		
		System.out.println("Inicio obtener pijamas:" + LocalDateTime.now());
		
		Categoria categoria = new Categoria();
		categoria = categoriaRepository.findByNombre(nombreCategoria).get(0);
		
		Item item = new Item();
		item = itemRepository.findByNombreAndCategoria(nombreItem, categoria.getId());
		
		List<Producto> productos = productoRepository.obtenerProductosPorIdItemYIdCategoria(item.getId(), categoria.getId());
		
		List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
		
		productosDTO = transformarListaObjetoPijamasAListaPijamasProductoDTO(productos);
			
		return productosDTO;		
	}

	@Override
	public ProductoDTO obtenerProductoPorId(Integer productoId) {
		Producto producto = productoRepository.obtenerProductoPorId(productoId);
		
		return transformarObjetoProductoADTO(producto);
	}
	
	@Override
	public ItemDTO obtenerItemPorNombreYCategoria(String nombreItem, Integer categoriaId) {
		
		Item item = itemRepository.findByNombreAndCategoria(nombreItem, categoriaId);
		
		ItemDTO itemDTO = transformarObjetoItemADTO(item);
		
		return itemDTO;
	}
	
	private List<ProductoDTO> transformarListaObjetoPijamasAListaPijamasProductoDTO(List<Producto> pijamas) {
		
		List<ProductoDTO> listaPijamasProductoDTO = new ArrayList<>();
		ProductoDTO pijamaProductoDTO = new ProductoDTO();
		for (Producto producto : pijamas) {
			
			pijamaProductoDTO = new ProductoDTO();
			
			pijamaProductoDTO.setId(producto.getId());
			pijamaProductoDTO.setNombre(producto.getNombre());
			pijamaProductoDTO.setPrecio(producto.getPrecio());
			pijamaProductoDTO.setRutaFoto(producto.getRutaFoto());
			pijamaProductoDTO.setItem(transformarObjetoItemADTO(producto.getItem()));
			
			
			listaPijamasProductoDTO.add(pijamaProductoDTO);
			
		}
		
		return listaPijamasProductoDTO;
		
	}
	
	private ProductoDTO transformarObjetoProductoADTO(Producto producto) {
		
		ProductoDTO productoDTO = new ProductoDTO();
		
		productoDTO.setId(producto.getId());
		productoDTO.setCategoria(producto.getCategoria().getNombre());
		
		List<ColorDTO> listaColoresDTOProducto = new ArrayList<>();
		
		for (Color color : producto.getColores()) {
			
			listaColoresDTOProducto.add(transformarObjetoColorADTO(color));

		}
		
		productoDTO.setColores(listaColoresDTOProducto);
		productoDTO.setDescripcion(producto.getDescripcion());
		productoDTO.setItem(transformarObjetoItemADTO(producto.getItem()));
		productoDTO.setLinea(transformarObjetoLineaADTO(producto.getLinea()));
		productoDTO.setMaterial(producto.getMaterial().getMaterial());
		productoDTO.setNombre(producto.getNombre());
		productoDTO.setPrecio(producto.getPrecio());
		productoDTO.setRutaFoto(producto.getRutaFoto());
		
		List<TallaDTO> listaTallasDTOProducto = new ArrayList<>();
		for (Talla talla : producto.getTallas()) {
			
			listaTallasDTOProducto.add(transformarObjetoTallaADTO(talla));
			
		}
		
		productoDTO.setTallas(listaTallasDTOProducto);
		
		return productoDTO;
	}
	
	private ColorDTO transformarObjetoColorADTO(Color color) {
		
		ColorDTO colorDTO = new ColorDTO();
		colorDTO.setId(color.getId());
		colorDTO.setColor(color.getColor());
		colorDTO.setClaseColor(color.getClaseColor());
		
		return colorDTO;
	}
	
	private ItemDTO transformarObjetoItemADTO(Item item) {
		
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setId(item.getId());
		itemDTO.setLink(item.getLink());
		itemDTO.setNombreItem(item.getNombre());
		itemDTO.setRutaFoto(item.getRutaFoto());
		
		return itemDTO;
	}
	
	private LineaDTO transformarObjetoLineaADTO(Linea linea) {
		
		LineaDTO lineaDTO = new LineaDTO();
		lineaDTO.setId(linea.getId());
		lineaDTO.setLinea(linea.getNombre());
		
		return lineaDTO;	
	}
	
	private TallaDTO transformarObjetoTallaADTO(Talla talla) {
		
		TallaDTO tallaDTO = new TallaDTO();
		
		tallaDTO.setId(talla.getId());
		tallaDTO.setTalla(talla.getTalla());
		
		return tallaDTO;	
	}

}
