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
import com.project.juanata.core.model.Item;
import com.project.juanata.core.model.Producto;
import com.project.juanata.core.services.ProductoService;
import com.project.juanata.core.util.Constantes;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping(path = "/pijamas/mujer")
	public ModelAndView pijamasMujer() {
		ModelAndView modelAndView = new ModelAndView(Vistas.LISTA_PRODUCTO_ESPECIFICO);
		modelAndView.addObject("productos", productoService.getPijamasMujer());
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
	public ModelAndView getPijamaIndividualMujer(@PathVariable(name = "idPijama") Long idPijama) {
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE);
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_PIJAMAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_PANTUFLAS_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		List<Producto> pijamas = new ArrayList<Producto>();
		
		pijamas = productoService.getPijamasMujer();
		Producto pijama = new Producto();
		
		for(Producto eachPijama: pijamas) {
			if(eachPijama.getId().equals(idPijama)) {
				pijama = eachPijama;
				break;
			}
		}
		
		if(pijama.getId() != null) {			
			modelAndView.addObject("producto", pijama);
		}
		
		return modelAndView;
	}
	
	@GetMapping(path = "/pantuflas/mujer")
	public ModelAndView pantuflasMujer() {
		ModelAndView modelAndView = new ModelAndView(Vistas.LISTA_PRODUCTO_ESPECIFICO);
		modelAndView.addObject("productos", productoService.getPantuflasMujer());
		
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
	public ModelAndView getPantuflasIndividualMujer(@PathVariable(name = "idPantuflas") Long idPantuflas) {
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE);
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_PANTUFLAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_PANTUFLAS_MUJER);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		List<Producto> listaPantuflas = new ArrayList<Producto>();
		
		listaPantuflas = productoService.getPantuflasMujer();
		Producto pantuflas = new Producto();
		
		for(Producto eachPantuflas: listaPantuflas) {
			if(eachPantuflas.getId().equals(idPantuflas)) {
				pantuflas = eachPantuflas;
				break;
			}
		}
		
		if(pantuflas.getId() != null) {			
			modelAndView.addObject("producto", pantuflas);
		}
		
		return modelAndView;
	}
	
	@GetMapping(path = "/pijamas/hombre")
	public ModelAndView pijamasHombre() {
		ModelAndView modelAndView = new ModelAndView(Vistas.LISTA_PRODUCTO_ESPECIFICO);
		modelAndView.addObject("productos", productoService.getPijamasHombre());
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
	public ModelAndView getPijamaIndividualHombre(@PathVariable(name = "idPijama") Long idPijama) {
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE);
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_HOMBRE);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_HOMBRE);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_PIJAMAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_PIJAMAS_HOMBRE);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		List<Producto> pijamas = new ArrayList<Producto>();
		
		pijamas = productoService.getPijamasHombre();
		Producto pijama = new Producto();
		
		for(Producto eachPijama: pijamas) {
			if(eachPijama.getId().equals(idPijama)) {
				pijama = eachPijama;
				break;
			}
		}
		
		if(pijama.getId() != null) {			
			modelAndView.addObject("producto", pijama);
		}
		
		return modelAndView;
	}
	
	@GetMapping(path = "/pantuflas/hombre")
	public ModelAndView pantuflasHombre() {
		ModelAndView modelAndView = new ModelAndView(Vistas.LISTA_PRODUCTO_ESPECIFICO);
		modelAndView.addObject("productos", productoService.getPantuflasHombre());
		
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
	public ModelAndView getPantuflasIndividualHombre(@PathVariable(name = "idPantuflas") Long idPantuflas) {
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE);
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_HOMBRE);
		modelAndView.addObject("linkBreadcrumbCategoria", Constantes.LINK_BREADCRUMB_CATEGORIA_HOMBRE);
		
		modelAndView.addObject("tituloBreadcrumbProducto", Constantes.TITULO_BREADCRUMB_PANTUFLAS);
		modelAndView.addObject("linkBreadcrumbProducto", Constantes.LINK_BREADCRUMB_PANTUFLAS_HOMBRE);
		
		modelAndView.addObject("tituloBreadcrumbDetalleProducto", Constantes.TITULO_BREADCRUMB_DETALLE_PRODUCTO);
		
		List<Producto> listaPantuflas = new ArrayList<Producto>();
		
		listaPantuflas = productoService.getPantuflasHombre();
		Producto pantuflas = new Producto();
		
		for(Producto eachPantuflas: listaPantuflas) {
			if(eachPantuflas.getId().equals(idPantuflas)) {
				pantuflas = eachPantuflas;
				break;
			}
		}
		
		if(pantuflas.getId() != null) {			
			modelAndView.addObject("producto", pantuflas);
		}
		
		return modelAndView;
	}
}
