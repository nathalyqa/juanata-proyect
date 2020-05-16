package com.project.juanata.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.juanata.core.configuration.Vistas;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping(path = "home")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(Vistas.HOME);
		
		return modelAndView;
	}

}
