package com.project.juanata.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.juanata.core.configuration.Vistas;
import com.project.juanata.core.services.CategoriasService;
import com.project.juanata.core.util.Constantes;

/**
 * Clase que permite la conexión de las pantallas con el backend (Pantallas que tienen que ver con categorias)
 * Definición Categoria: Clasificación por tipo de audiencia.
 * - Categoria Mujer
 * - Categoria Hombre
 * @author Nathaly Quintero Aristizabal
 *
 */

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private CategoriasService categoriaService;
	
	@GetMapping(path = "/mujer")
	public ModelAndView productosMujer() {
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTOS_CATEGORIA_ESPECIFICA);
		modelAndView.addObject("items", categoriaService.getItemsMujer());
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_MUJER);
		
		modelAndView.addObject("tituloProductosCategoria", Constantes.TITULO_PRODUCTOS_CATEGORIA_MUJER);
		
		modelAndView.addObject("esCategoriaMujer", Boolean.TRUE);
		
		return modelAndView;
	}
	
	@GetMapping(path = "/hombre")
	public ModelAndView productosHombre() {
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTOS_CATEGORIA_ESPECIFICA);
		modelAndView.addObject("items", categoriaService.getItemsHombre());
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbCategoria", Constantes.TITULO_BREADCRUMB_HOMBRE);
		
		modelAndView.addObject("tituloProductosCategoria", Constantes.TITULO_PRODUCTOS_CATEGORIA_HOMBRE);
		
		modelAndView.addObject("esCategoriaMujer", Boolean.FALSE);
		
		return modelAndView;
	}
	
}
