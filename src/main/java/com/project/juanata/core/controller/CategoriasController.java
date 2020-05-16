package com.project.juanata.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.juanata.core.configuration.Vistas;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@GetMapping(path = "/mujer")
	public ModelAndView mujer() {
		ModelAndView modelAndView = new ModelAndView(Vistas.CATEGORIA_MUJER);
		
		return modelAndView;
	}

}
