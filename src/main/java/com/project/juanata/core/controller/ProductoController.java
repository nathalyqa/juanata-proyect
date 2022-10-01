package com.project.juanata.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.juanata.core.configuration.Vistas;
import com.project.juanata.core.model.dto.ItemDTO;
import com.project.juanata.core.model.dto.ProductoDTO;
import com.project.juanata.core.services.CategoriasService;
import com.project.juanata.core.services.ProductoService;
import com.project.juanata.core.util.Constantes;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriasService categoriaService;
	
	@GetMapping(path = "/pijamas/mujer")
	public ModelAndView pijamasMujer() {
		ModelAndView modelAndView = new ModelAndView(Vistas.LISTA_PRODUCTO_ESPECIFICO);
		modelAndView.addObject("productos", productoService.getProductosPorItemYCategoria(Constantes.CATEGORIA_MUJER, Constantes.ITEM_PIJAMAS));
		modelAndView.addObject("item", Constantes.ITEM_PIJAMAS);
	
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_PIJAMAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_PIJAMAS_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		
		return modelAndView;
	}
	
	@GetMapping(path = "/pijamas/mujer/{idPijama}")
	public ModelAndView getPijamaIndividualMujer(@PathVariable(name = "idPijama") Integer idPijama) {
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE);
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_PIJAMAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_PIJAMAS_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		ProductoDTO pijama = new ProductoDTO();
		
		pijama = productoService.obtenerProductoPorId(idPijama);
		
		Integer categoriaId = categoriaService.obtenerIdCategoriaPorNombre(pijama.getCategoria());
		
		ItemDTO salidaDeBanioItem = productoService.obtenerItemPorNombreYCategoria(Constantes.ITEM_SALIDAS_DE_BANIO, categoriaId);
		
		List<Integer> idsItemsExcepcion = new ArrayList<>();
		idsItemsExcepcion.add(pijama.getItem().getId());
		idsItemsExcepcion.add(salidaDeBanioItem.getId());
		
		modelAndView.addObject("otrosProductos", categoriaService.get2ItemsAleatorios(idsItemsExcepcion));
		
		if(pijama.getId() != null) {			
			modelAndView.addObject("producto", pijama);
		}
		
		return modelAndView;
	}
	
	@GetMapping(path = "/pantuflas/mujer")
	public ModelAndView pantuflasMujer() {
		ModelAndView modelAndView = new ModelAndView(Vistas.LISTA_PRODUCTO_ESPECIFICO);
		modelAndView.addObject("productos", productoService.getProductosPorItemYCategoria(Constantes.CATEGORIA_MUJER, Constantes.ITEM_PANTUFLAS));
		
		modelAndView.addObject("item", Constantes.ITEM_PANTUFLAS);
	
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_PANTUFLAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_PANTUFLAS_MUJER);
		
		return modelAndView;
	}
	
	@GetMapping(path = "/pantuflas/mujer/{idPantuflas}")
	public ModelAndView getPantuflasIndividualMujer(@PathVariable(name = "idPantuflas") Integer idPantuflas) {
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE);
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_PANTUFLAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_PANTUFLAS_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		ProductoDTO pantuflas = productoService.obtenerProductoPorId(idPantuflas);
		
		Integer categoriaId = categoriaService.obtenerIdCategoriaPorNombre(pantuflas.getCategoria());
		
		ItemDTO salidaDeBanioItem = productoService.obtenerItemPorNombreYCategoria(Constantes.ITEM_SALIDAS_DE_BANIO, categoriaId);
		
		List<Integer> idsItemsExcepcion = new ArrayList<>();
		idsItemsExcepcion.add(pantuflas.getItem().getId());
		idsItemsExcepcion.add(salidaDeBanioItem.getId());
		
		modelAndView.addObject("otrosProductos", categoriaService.get2ItemsAleatorios(idsItemsExcepcion));

		if(pantuflas.getId() != null) {			
			modelAndView.addObject("producto", pantuflas);
		}
		
		return modelAndView;
	}
	
	@GetMapping(path = "/pijamas/hombre")
	public ModelAndView pijamasHombre() {
		ModelAndView modelAndView = new ModelAndView(Vistas.LISTA_PRODUCTO_ESPECIFICO);
		modelAndView.addObject("productos", productoService.getProductosPorItemYCategoria(Constantes.CATEGORIA_HOMBRE, Constantes.ITEM_PIJAMAS));
		modelAndView.addObject("item", Constantes.ITEM_PIJAMAS);
	
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_HOMBRE);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_HOMBRE);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_PIJAMAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_PIJAMAS_HOMBRE);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		
		return modelAndView;
	}
	
	@GetMapping(path = "/pijamas/hombre/{idPijama}")
	public ModelAndView getPijamaIndividualHombre(@PathVariable(name = "idPijama") Integer idPijama) {
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE);
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_HOMBRE);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_HOMBRE);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_PIJAMAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_PIJAMAS_HOMBRE);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		ProductoDTO pijama = productoService.obtenerProductoPorId(idPijama);
		
		Integer categoriaId = categoriaService.obtenerIdCategoriaPorNombre(Constantes.CATEGORIA_MUJER);
		
		ItemDTO salidaDeBanioItem = productoService.obtenerItemPorNombreYCategoria(Constantes.ITEM_SALIDAS_DE_BANIO, categoriaId);

		List<Integer> idsItemsExcepcion = new ArrayList<>();
		idsItemsExcepcion.add(pijama.getItem().getId());
		idsItemsExcepcion.add(salidaDeBanioItem.getId());
		
		modelAndView.addObject("otrosProductos", categoriaService.get2ItemsAleatorios(idsItemsExcepcion));
	
		if(pijama.getId() != null) {			
			modelAndView.addObject("producto", pijama);
		}
		
		return modelAndView;
	}
	
	@GetMapping(path = "/pantuflas/hombre")
	public ModelAndView pantuflasHombre() {
		ModelAndView modelAndView = new ModelAndView(Vistas.LISTA_PRODUCTO_ESPECIFICO);
		modelAndView.addObject("productos", productoService.getProductosPorItemYCategoria(Constantes.CATEGORIA_HOMBRE, Constantes.ITEM_PANTUFLAS));
		
		modelAndView.addObject("item", Constantes.ITEM_PANTUFLAS);
	
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_HOMBRE);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_HOMBRE);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_PANTUFLAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_PANTUFLAS_HOMBRE);
		
		return modelAndView;
	}
	
	
	@GetMapping(path = "/pantuflas/hombre/{idPantuflas}")
	public ModelAndView getPantuflasIndividualHombre(@PathVariable(name = "idPantuflas") Integer idPantuflas) {
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE);
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_HOMBRE);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_HOMBRE);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_PANTUFLAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_PANTUFLAS_HOMBRE);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		ProductoDTO pantuflas = productoService.obtenerProductoPorId(idPantuflas);
		
		Integer categoriaId = categoriaService.obtenerIdCategoriaPorNombre(Constantes.CATEGORIA_MUJER);
		
		ItemDTO salidaDeBanioItem = productoService.obtenerItemPorNombreYCategoria(Constantes.ITEM_SALIDAS_DE_BANIO, categoriaId);

		List<Integer> idsItemsExcepcion = new ArrayList<>();
		idsItemsExcepcion.add(pantuflas.getItem().getId());
		idsItemsExcepcion.add(salidaDeBanioItem.getId());
		
		modelAndView.addObject("otrosProductos", categoriaService.get2ItemsAleatorios(idsItemsExcepcion));
		
		if(pantuflas.getId() != null) {			
			modelAndView.addObject("producto", pantuflas);
		}
		
		return modelAndView;
	}
	
	@GetMapping(path = "/salidasDeBanio/mujer")
	public ModelAndView salidasDeBanioMujer() {
		
		ModelAndView modelAndView = new ModelAndView(Vistas.LISTA_PRODUCTO_ESPECIFICO);
		
		modelAndView.addObject("productos", productoService.getProductosPorItemYCategoria(Constantes.CATEGORIA_MUJER, Constantes.ITEM_SALIDAS_DE_BANIO));
		
		modelAndView.addObject("item", Constantes.ITEM_SALIDAS_DE_BANIO);
	
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_SALIDAS_DE_BANIO);
		
		return modelAndView;
	}
	
	@GetMapping(path = "/salidasDeBanio/mujer/{idSalidaDeBanio}")
	public ModelAndView getSalidaDeBanioPorId(@PathVariable(name = "idSalidaDeBanio") Integer idSalidaDeBanio) {
		
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE);
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_SALIDAS_DE_BANIO);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_SALIDAS_DE_BANIO_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		ProductoDTO salidaDeBanio = productoService.obtenerProductoPorId(idSalidaDeBanio);
		
		Integer categoriaId = categoriaService.obtenerIdCategoriaPorNombre(salidaDeBanio.getCategoria());

		List<Integer> idsItemsExcepcion = new ArrayList<>();
		idsItemsExcepcion.add(salidaDeBanio.getItem().getId());
		
		modelAndView.addObject("otrosProductos", categoriaService.get2ItemsAleatorios(idsItemsExcepcion));
		
		if(salidaDeBanio.getId() != null) {			
			modelAndView.addObject("producto", salidaDeBanio);
		}
		
		return modelAndView;
	}
	
	@GetMapping(path = "/body/mujer")
	public ModelAndView bodysMujer() {
		ModelAndView modelAndView = new ModelAndView(Vistas.LISTA_PRODUCTO_ESPECIFICO);
		modelAndView.addObject("productos", productoService.getProductosPorItemYCategoria(Constantes.CATEGORIA_MUJER, Constantes.ITEM_BODYS));
		
		modelAndView.addObject("item", Constantes.ITEM_BODYS);
	
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_BODY);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_BODY_MUJER);
		
		return modelAndView;
	}
	
	@GetMapping(path = "/body/mujer/{idBody}")
	public ModelAndView getBodyPorId(@PathVariable(name = "idBody") Integer idBody) {
		
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE);
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_BODY);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_BODY_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		ProductoDTO body = productoService.obtenerProductoPorId(idBody);
		
		Integer categoriaId = categoriaService.obtenerIdCategoriaPorNombre(body.getCategoria());
		
		ItemDTO salidaDeBanioItem = productoService.obtenerItemPorNombreYCategoria(Constantes.ITEM_SALIDAS_DE_BANIO, categoriaId);

		List<Integer> idsItemsExcepcion = new ArrayList<>();
		idsItemsExcepcion.add(body.getItem().getId());
		idsItemsExcepcion.add(salidaDeBanioItem.getId());
		
		modelAndView.addObject("otrosProductos", categoriaService.get2ItemsAleatorios(idsItemsExcepcion));
		
		if(body.getId() != null) {			
			modelAndView.addObject("producto", body);
		}
		
		return modelAndView;
	}
	
	@GetMapping(path = "/chaquetas/mujer")
	public ModelAndView chaquetasMujer() {
		ModelAndView modelAndView = new ModelAndView(Vistas.LISTA_PRODUCTO_ESPECIFICO);
		modelAndView.addObject("productos", productoService.getProductosPorItemYCategoria(Constantes.CATEGORIA_MUJER, Constantes.ITEM_CHAQUETAS));
		
		modelAndView.addObject("item", Constantes.ITEM_CHAQUETAS);
	
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_CHAQUETAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_CHAQUETAS_MUJER);
		
		return modelAndView;
	}
	
	@GetMapping(path = "/body/chaquetas/{idChaqueta}")
	public ModelAndView getChaquetaPorId(@PathVariable(name = "idChaqueta") Integer idChaqueta) {
		
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE);
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_CHAQUETAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_CHAQUETAS_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		ProductoDTO chacketa = productoService.obtenerProductoPorId(idChaqueta);
		
		Integer categoriaId = categoriaService.obtenerIdCategoriaPorNombre(chacketa.getCategoria());
		
		ItemDTO salidaDeBanioItem = productoService.obtenerItemPorNombreYCategoria(Constantes.ITEM_SALIDAS_DE_BANIO, categoriaId);

		List<Integer> idsItemsExcepcion = new ArrayList<>();
		idsItemsExcepcion.add(chacketa.getItem().getId());
		idsItemsExcepcion.add(salidaDeBanioItem.getId());
		
		modelAndView.addObject("otrosProductos", categoriaService.get2ItemsAleatorios(idsItemsExcepcion));
		
		if(chacketa.getId() != null) {			
			modelAndView.addObject("producto", chacketa);
		}
		
		return modelAndView;
	}
}
