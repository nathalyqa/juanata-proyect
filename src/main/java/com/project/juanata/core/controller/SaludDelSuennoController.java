package com.project.juanata.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.juanata.core.configuration.Vistas;

@Controller
@RequestMapping("/")
public class SaludDelSuennoController {
	
	@GetMapping(path = "/saludDelSuenno")
	public ModelAndView productosMujer() {
		ModelAndView modelAndView = new ModelAndView(Vistas.SALUD_DEL_SUENNO);
		
		return modelAndView;
	}

}
