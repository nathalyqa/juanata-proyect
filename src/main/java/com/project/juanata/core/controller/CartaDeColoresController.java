package com.project.juanata.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.juanata.core.configuration.Vistas;
import com.project.juanata.core.services.CartaDeColoresService;
import com.project.juanata.core.util.Constantes;

/**
 * Clase que permite visualizar la carta de colores.
 * @author natik
 *
 */

@Controller
@RequestMapping("/cartaDeColores")
public class CartaDeColoresController {
	
	@Autowired
	public CartaDeColoresService cartaDeColoresService;
	
	@GetMapping(path = "/obtenerTodosLosColores")
	public ModelAndView getCartaDeColores() {
		
		ModelAndView modelAndView = new ModelAndView(Vistas.CARTA_DE_COLORES);
		modelAndView.addObject("colores", cartaDeColoresService.obtenerColores());
		
		modelAndView.addObject("tituloBreadcrumbInicio", Constantes.TITULO_BREADCRUMB_INICIO);
		modelAndView.addObject("linkBreadcrumbInicio", Constantes.LINK_BREADCRUMB_INICIO);
		
		modelAndView.addObject("tituloBreadcrumbSeccion", Constantes.TITULO_BREADCRUMB_CARTA_DE_COLORES);
		
		return modelAndView;
		
	}

}
