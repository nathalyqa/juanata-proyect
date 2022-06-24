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
import com.project.juanata.core.model.Item;
import com.project.juanata.core.model.Linea;
import com.project.juanata.core.model.Producto;
import com.project.juanata.core.model.Talla;
import com.project.juanata.core.util.Constantes;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@GetMapping(path = "/mujer")
	public ModelAndView productosMujer() {
		ModelAndView modelAndView = new ModelAndView(Vistas.CATEGORIA_MUJER);
		modelAndView.addObject("items", getItemsMujer());
		
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
		ModelAndView modelAndView = new ModelAndView(Vistas.PRODUCTO_DETALLE_MUJER);
		
		List<Producto> pijamas = new ArrayList<Producto>();
		
		pijamas = getPijamasMujer();
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
	
	private List<Producto> getPijamasMujer(){
		List<Producto> pijamasMujer = new ArrayList<Producto>();
		
		List<Color> coloresPijama1 = new ArrayList<Color>();
		
		coloresPijama1.add(getColor(0L));
		coloresPijama1.add(getColor(2L));
		coloresPijama1.add(getColor(3L));
		
		List<Color> coloresPijama2 = new ArrayList<Color>();
		coloresPijama2.add(getColor(2L));
		coloresPijama2.add(getColor(3L));
		
		List<Color> coloresPijama3 = new ArrayList<Color>();
		coloresPijama3.add(getColor(0L));
		coloresPijama3.add(getColor(3L));
		coloresPijama3.add(getColor(1L));
		coloresPijama3.add(getColor(2L));
		
		List<Color> coloresPijama4 = new ArrayList<Color>();
		coloresPijama4.add(getColor(2L));
		coloresPijama4.add(getColor(0L));
		coloresPijama4.add(getColor(3L));
		
		List<Color> coloresPijama5 = new ArrayList<Color>();
		coloresPijama5.add(getColor(0L));
		
		
		List<Color> coloresPijama6 = new ArrayList<Color>();
		coloresPijama6.add(getColor(0L));
		coloresPijama6.add(getColor(2L));
		
		List<Color> coloresPijama7 = new ArrayList<Color>();
		coloresPijama7.add(getColor(1L));
		
		List<Color> coloresPijama8 = new ArrayList<Color>();
		coloresPijama8.add(getColor(0L));
		coloresPijama8.add(getColor(1L));
		coloresPijama8.add(getColor(2L));
		coloresPijama8.add(getColor(3L));
		
		Linea lineaClasica = new Linea();
		lineaClasica.setId(0L);
		lineaClasica.setLinea(Constantes.LINEA_CLASICA);
		
		Linea lineaCatalogo = new Linea();
		lineaCatalogo.setId(0L);
		lineaCatalogo.setLinea(Constantes.LINEA_CATALOGO);
		
		List<Talla> tallasPijama = new ArrayList<Talla>();
		tallasPijama.add(new Talla(0L,"XS"));
		tallasPijama.add(new Talla(1L,"S"));
		tallasPijama.add(new Talla(2L,"M"));
		tallasPijama.add(new Talla(3L,"L"));
		tallasPijama.add(new Talla(4L,"XL"));

		pijamasMujer.add(new Producto(0L,"Pijama Alhena",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama1, lineaClasica, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"_MG_8109.jpg", Constantes.CATEGORIA_MUJER)));
		pijamasMujer.add(new Producto(1L,"Pijama Alaya",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama2, lineaCatalogo, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"_MG_8109.jpg", Constantes.CATEGORIA_MUJER)));
		pijamasMujer.add(new Producto(2L,"Pijama Bianca",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama3, lineaClasica, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"_MG_8109.jpg", Constantes.CATEGORIA_MUJER)));
		pijamasMujer.add(new Producto(3L,"Pijama Larisa",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama4, lineaCatalogo, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"_MG_8109.jpg", Constantes.CATEGORIA_MUJER)));
		pijamasMujer.add(new Producto(4L,"Pijama Vega",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama5, lineaClasica, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"_MG_8109.jpg", Constantes.CATEGORIA_MUJER)));
		pijamasMujer.add(new Producto(5L,"Pijama Maia",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama6, lineaCatalogo, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"_MG_8109.jpg", Constantes.CATEGORIA_MUJER)));
		pijamasMujer.add(new Producto(6L,"Pijama Miranda",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama7, lineaClasica, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"_MG_8109.jpg", Constantes.CATEGORIA_MUJER)));
		pijamasMujer.add(new Producto(7L,"Pijama Adele",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "_MG_8109.jpg", coloresPijama8, lineaCatalogo, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"_MG_8109.jpg", Constantes.CATEGORIA_MUJER)));
		
		return pijamasMujer;
	}
	
	private List<Color> getColores(){
		List<Color> colores = new ArrayList<Color>();
		colores.add(new Color(0L,"color-azulTurqueza", "Azul Turqueza"));
		colores.add(new Color(1L,"color-rojo", "Rojo"));
		colores.add(new Color(2L,"color-gris", "Gris"));
		colores.add(new Color(3L,"color-azulJuanata", "Azul Oscuro"));
		
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
	
	private List<Item> getItemsMujer(){
		List<Item> items = new ArrayList<Item>();
		
		items.add(new Item(0L,"Pijamas","_MG_8109.jpg",Constantes.CATEGORIA_MUJER));
		items.add(new Item(1L,"Pantuflas","_MG_8109.jpg",Constantes.CATEGORIA_MUJER));
		items.add(new Item(1L,"Bodys","_MG_8109.jpg",Constantes.CATEGORIA_MUJER));
		items.add(new Item(1L,"Chaquetas","_MG_8109.jpg",Constantes.CATEGORIA_MUJER));
		
		return items;
	}
}
