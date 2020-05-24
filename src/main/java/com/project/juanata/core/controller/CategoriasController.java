package com.project.juanata.core.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.juanata.core.configuration.Vistas;
import com.project.juanata.core.model.Color;
import com.project.juanata.core.model.Pijama;
import com.project.juanata.core.util.Constantes;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@GetMapping(path = "/mujer")
	public ModelAndView mujer() {
		ModelAndView modelAndView = new ModelAndView(Vistas.CATEGORIA_MUJER);
		
		return modelAndView;
	}
	
	@GetMapping(path = "/mujer/pijamas")
	public ModelAndView pijamasMujer() {
		ModelAndView modelAndView = new ModelAndView(Vistas.CATEGORIA_MUJER_PIJAMAS);
		modelAndView.addObject("pijamasMujer", getPijamasMujer());
		
		return modelAndView;
	}
	
	@GetMapping(path = "/mujer/pijamas/{idPijama}")
	public ModelAndView getPijamaIndividual(@PathVariable(name = "idPijama") Long idPijama) {
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE);
		
		List<Pijama> pijamas = new ArrayList<Pijama>();
		
		pijamas = getPijamasMujer();
		Pijama pijama = new Pijama();
		
		for(Pijama eachPijama: pijamas) {
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
	
	private List<Pijama> getPijamasMujer(){
		List<Pijama> pijamasMujer = new ArrayList<Pijama>();
		
		List<Color> coloresPijama1 = new ArrayList<Color>();
		
		coloresPijama1.add(getColor(0L));
		coloresPijama1.add(getColor(2L));
		coloresPijama1.add(getColor(3L));
		
		List<Color> coloresPijama2 = new ArrayList<Color>();
		coloresPijama2.add(getColor(4L));
		coloresPijama2.add(getColor(3L));
		
		List<Color> coloresPijama3 = new ArrayList<Color>();
		coloresPijama3.add(getColor(0L));
		coloresPijama3.add(getColor(3L));
		coloresPijama3.add(getColor(5L));
		coloresPijama3.add(getColor(4L));
		
		List<Color> coloresPijama4 = new ArrayList<Color>();
		coloresPijama4.add(getColor(2L));
		coloresPijama4.add(getColor(0L));
		coloresPijama4.add(getColor(5L));
		
		List<Color> coloresPijama5 = new ArrayList<Color>();
		coloresPijama5.add(getColor(4L));
		
		
		List<Color> coloresPijama6 = new ArrayList<Color>();
		coloresPijama6.add(getColor(4L));
		coloresPijama6.add(getColor(2L));
		
		List<Color> coloresPijama7 = new ArrayList<Color>();
		coloresPijama7.add(getColor(1L));
		
		List<Color> coloresPijama8 = new ArrayList<Color>();
		coloresPijama8.add(getColor(0L));
		coloresPijama8.add(getColor(1L));
		coloresPijama8.add(getColor(2L));
		coloresPijama8.add(getColor(3L));
		coloresPijama8.add(getColor(4L));
		
		pijamasMujer.add(new Pijama(0L,"Pijama1",Constantes.REFERENCIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama1));
		pijamasMujer.add(new Pijama(1L,"Pijama2",Constantes.REFERENCIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama2));
		pijamasMujer.add(new Pijama(2L,"Pijama3",Constantes.REFERENCIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama3));
		pijamasMujer.add(new Pijama(3L,"Pijama4",Constantes.REFERENCIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama4));
		pijamasMujer.add(new Pijama(4L,"Pijama5",Constantes.REFERENCIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama5));
		pijamasMujer.add(new Pijama(5L,"Pijama6",Constantes.REFERENCIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama6));
		pijamasMujer.add(new Pijama(6L,"Pijama7",Constantes.REFERENCIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama7));
		pijamasMujer.add(new Pijama(7L,"Pijama8",Constantes.REFERENCIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama8));
		
		return pijamasMujer;
	}
	
	private List<Color> getColores(){
		List<Color> colores = new ArrayList<Color>();
		colores.add(new Color(0L,"color-azulTurqueza"));
		colores.add(new Color(2L,"color-rojo"));
		colores.add(new Color(3L,"color-gris"));
		colores.add(new Color(4L,"color-azulJuanata"));
		
		return colores;
		
	}
	
	private Color getColor(Long id) {
		
		Color color = new Color();
		List<Color> colores = getColores();
		
		for(Color eachColor : colores) {
			if(eachColor.getId().equals(id)) {
				color = eachColor;
				break;
			}
		}
		
		return color;
		
	}
	
	

}
