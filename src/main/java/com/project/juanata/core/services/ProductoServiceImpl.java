package com.project.juanata.core.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.juanata.core.model.Color;
import com.project.juanata.core.model.Item;
import com.project.juanata.core.model.Linea;
import com.project.juanata.core.model.Producto;
import com.project.juanata.core.model.Talla;
import com.project.juanata.core.util.Constantes;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Override
	public List<Producto> getPijamasMujer() {
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
		
		Linea lineaPijamasClasica = new Linea();
		lineaPijamasClasica.setId(0L);
		lineaPijamasClasica.setLinea(Constantes.LINEA_PIJAMAS_CLASICA);
		
		Linea lineaPijamasJuvenil = new Linea();
		lineaPijamasJuvenil.setId(0L);
		lineaPijamasJuvenil.setLinea(Constantes.LINEA_PIJAMAS_JUVENIL);
		
		List<Talla> tallasPijama = new ArrayList<Talla>();
		tallasPijama.add(new Talla(0L,"XS"));
		tallasPijama.add(new Talla(1L,"S"));
		tallasPijama.add(new Talla(2L,"M"));
		tallasPijama.add(new Talla(3L,"L"));
		tallasPijama.add(new Talla(4L,"XL"));

		pijamasMujer.add(new Producto(0L,"Pijama Alhena",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPijama1, lineaPijamasClasica, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pijamas/mujer")));
		pijamasMujer.add(new Producto(1L,"Pijama Alaya",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPijama2, lineaPijamasJuvenil, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pijamas/mujer")));
		pijamasMujer.add(new Producto(2L,"Pijama Bianca",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPijama3, lineaPijamasClasica, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pijamas/mujer")));
		pijamasMujer.add(new Producto(3L,"Pijama Larisa",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPijama4, lineaPijamasJuvenil, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pijamas/mujer")));
		pijamasMujer.add(new Producto(4L,"Pijama Vega",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPijama5, lineaPijamasClasica, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pijamas/mujer")));
		pijamasMujer.add(new Producto(5L,"Pijama Maia",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPijama6, lineaPijamasJuvenil, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pijamas/mujer")));
		pijamasMujer.add(new Producto(6L,"Pijama Miranda",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPijama7, lineaPijamasClasica, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pijamas/mujer")));
		pijamasMujer.add(new Producto(7L,"Pijama Adele",Constantes.CATEGORIA_MUJER, new BigDecimal(30000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPijama8, lineaPijamasJuvenil, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pijamas/mujer")));
		
		return pijamasMujer;
	}
	
	private Color getColor(Long id) {

		Color color = new Color();
		List<Color> colores = getColores();

		for (Color eachColor : colores) {
			if (eachColor.getId().equals(id)) {
				color = eachColor;
				break;
			}
		}

		return color;
	}
	
	private List<Color> getColores(){
		List<Color> colores = new ArrayList<Color>();
		colores.add(new Color(0L,"color-azulTurqueza", "Azul Turqueza"));
		colores.add(new Color(1L,"color-rojo", "Rojo"));
		colores.add(new Color(2L,"color-gris", "Gris"));
		colores.add(new Color(3L,"color-azulJuanata", "Azul Oscuro"));
		
		return colores;
		
	}

	@Override
	public List<Producto> getPantuflasMujer() {
		List<Producto> pantuflasMujer = new ArrayList<Producto>();
		
		List<Color> coloresPantuflas1 = new ArrayList<Color>();
		
		coloresPantuflas1.add(getColor(0L));
		coloresPantuflas1.add(getColor(2L));
		coloresPantuflas1.add(getColor(3L));
		
		List<Color> coloresPantuflas2 = new ArrayList<Color>();
		coloresPantuflas2.add(getColor(2L));
		coloresPantuflas2.add(getColor(3L));
		
		List<Color> coloresPantuflas3 = new ArrayList<Color>();
		coloresPantuflas3.add(getColor(0L));
		coloresPantuflas3.add(getColor(3L));
		coloresPantuflas3.add(getColor(1L));
		coloresPantuflas3.add(getColor(2L));
		
		List<Color> coloresPantuflas4 = new ArrayList<Color>();
		coloresPantuflas4.add(getColor(2L));
		coloresPantuflas4.add(getColor(0L));
		coloresPantuflas4.add(getColor(3L));
		
		List<Color> coloresPantuflas5 = new ArrayList<Color>();
		coloresPantuflas5.add(getColor(0L));
		
		
		List<Color> coloresPantuflas6 = new ArrayList<Color>();
		coloresPantuflas6.add(getColor(0L));
		coloresPantuflas6.add(getColor(2L));
		
		List<Color> coloresPantuflas7 = new ArrayList<Color>();
		coloresPantuflas7.add(getColor(1L));
		
		List<Color> coloresPantuflas8 = new ArrayList<Color>();
		coloresPantuflas8.add(getColor(0L));
		coloresPantuflas8.add(getColor(1L));
		coloresPantuflas8.add(getColor(2L));
		coloresPantuflas8.add(getColor(3L));
		
		Linea lineaPantuflasAbuelitas = new Linea();
		lineaPantuflasAbuelitas.setId(0L);
		lineaPantuflasAbuelitas.setLinea(Constantes.LINEA_PANTUFLAS_ABUELITAS);
		
		Linea lineaPantuflasCerradas = new Linea();
		lineaPantuflasCerradas.setId(0L);
		lineaPantuflasCerradas.setLinea(Constantes.LINEA_PANTUFLAS_CERRADAS);
		
		List<Talla> tallasPantuflas = new ArrayList<Talla>();
		tallasPantuflas.add(new Talla(0L,"35"));
		tallasPantuflas.add(new Talla(1L,"36"));
		tallasPantuflas.add(new Talla(2L,"37"));
		tallasPantuflas.add(new Talla(3L,"38"));
		tallasPantuflas.add(new Talla(4L,"39"));
		tallasPantuflas.add(new Talla(4L,"40"));
		tallasPantuflas.add(new Talla(4L,"41"));
		tallasPantuflas.add(new Talla(4L,"42"));
		tallasPantuflas.add(new Talla(4L,"43"));

		pantuflasMujer.add(new Producto(0L,"Pantuflas 1",Constantes.CATEGORIA_MUJER, new BigDecimal(15000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPantuflas1, lineaPantuflasAbuelitas, "Pantuflas para abuelitas", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pantuflas/mujer")));
		pantuflasMujer.add(new Producto(1L,"Pantuflas 2",Constantes.CATEGORIA_MUJER, new BigDecimal(15000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPantuflas2, lineaPantuflasCerradas, "Pantuflas cerradas para todo publico", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pantuflas/mujer")));
		pantuflasMujer.add(new Producto(2L,"Pantuflas 3",Constantes.CATEGORIA_MUJER, new BigDecimal(15000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPantuflas3, lineaPantuflasAbuelitas, "Pantuflas para abuelitas", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pantuflas/mujer")));
		pantuflasMujer.add(new Producto(3L,"Pantuflas 4",Constantes.CATEGORIA_MUJER, new BigDecimal(15000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPantuflas4, lineaPantuflasCerradas, "Pantuflas cerradas para todo publico", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pantuflas/mujer")));
		pantuflasMujer.add(new Producto(4L,"Pantuflas 5",Constantes.CATEGORIA_MUJER, new BigDecimal(15000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPantuflas5, lineaPantuflasAbuelitas, "Pantuflas para abuelitas", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pantuflas/mujer")));
		pantuflasMujer.add(new Producto(5L,"Pantuflas 6",Constantes.CATEGORIA_MUJER, new BigDecimal(15000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPantuflas6, lineaPantuflasCerradas, "Pantuflas cerradas para todo publico", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pantuflas/mujer")));
		pantuflasMujer.add(new Producto(6L,"Pantuflas 7",Constantes.CATEGORIA_MUJER, new BigDecimal(15000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPantuflas7, lineaPantuflasAbuelitas, "Pantuflas para abuelitas", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pantuflas/mujer")));
		pantuflasMujer.add(new Producto(7L,"Pantuflas 8",Constantes.CATEGORIA_MUJER, new BigDecimal(15000), "/img/categorias/mujeres/_MG_8109.jpg", coloresPantuflas8, lineaPantuflasCerradas, "Pantuflas cerradas para todo publico", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/mujeres/_MG_8109.jpg", "/producto/pantuflas/mujer")));
		
		return pantuflasMujer;
	}

	@Override
	public List<Producto> getPijamasHombre() {
		
		List<Producto> pijamasHombre = new ArrayList<Producto>();
		
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
		
		Linea lineaPijamasClasica = new Linea();
		lineaPijamasClasica.setId(0L);
		lineaPijamasClasica.setLinea(Constantes.LINEA_PIJAMAS_CLASICA);
		
		Linea lineaPijamasJuvenil = new Linea();
		lineaPijamasJuvenil.setId(0L);
		lineaPijamasJuvenil.setLinea(Constantes.LINEA_PIJAMAS_JUVENIL);
		
		List<Talla> tallasPijama = new ArrayList<Talla>();
		tallasPijama.add(new Talla(0L,"XS"));
		tallasPijama.add(new Talla(1L,"S"));
		tallasPijama.add(new Talla(2L,"M"));
		tallasPijama.add(new Talla(3L,"L"));
		tallasPijama.add(new Talla(4L,"XL"));

		pijamasHombre.add(new Producto(0L,"Pijama Marcos",Constantes.CATEGORIA_HOMBRE, new BigDecimal(30000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPijama1, lineaPijamasClasica, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pijamas/hombre")));
		pijamasHombre.add(new Producto(1L,"Pijama Miguel",Constantes.CATEGORIA_HOMBRE, new BigDecimal(30000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPijama2, lineaPijamasJuvenil, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pijamas/hombre")));
		pijamasHombre.add(new Producto(2L,"Pijama Santiago",Constantes.CATEGORIA_HOMBRE, new BigDecimal(30000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPijama3, lineaPijamasClasica, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pijamas/hombre")));
		pijamasHombre.add(new Producto(3L,"Pijama Felipe",Constantes.CATEGORIA_HOMBRE, new BigDecimal(30000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPijama4, lineaPijamasJuvenil, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pijamas/hombre")));
		pijamasHombre.add(new Producto(4L,"Pijama Ulises",Constantes.CATEGORIA_HOMBRE, new BigDecimal(30000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPijama5, lineaPijamasClasica, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pijamas/hombre")));
		pijamasHombre.add(new Producto(5L,"Pijama Fernando",Constantes.CATEGORIA_HOMBRE, new BigDecimal(30000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPijama6, lineaPijamasJuvenil, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pijamas/hombre")));
		pijamasHombre.add(new Producto(6L,"Pijama Angel",Constantes.CATEGORIA_HOMBRE, new BigDecimal(30000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPijama7, lineaPijamasClasica, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pijamas/hombre")));
		pijamasHombre.add(new Producto(7L,"Pijama Don Juan",Constantes.CATEGORIA_HOMBRE, new BigDecimal(30000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPijama8, lineaPijamasJuvenil, "Manga larga pantalón largo", "Tejido de punto", tallasPijama, new Item(0L,Constantes.ITEM_PIJAMAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pijamas/hombre")));
		
		return pijamasHombre;
	}

	@Override
	public List<Producto> getPantuflasHombre() {
		
		List<Producto> pantuflasHombre = new ArrayList<Producto>();
		
		List<Color> coloresPantuflas1 = new ArrayList<Color>();
		
		coloresPantuflas1.add(getColor(0L));
		coloresPantuflas1.add(getColor(2L));
		coloresPantuflas1.add(getColor(3L));
		
		List<Color> coloresPantuflas2 = new ArrayList<Color>();
		coloresPantuflas2.add(getColor(2L));
		coloresPantuflas2.add(getColor(3L));
		
		List<Color> coloresPantuflas3 = new ArrayList<Color>();
		coloresPantuflas3.add(getColor(0L));
		coloresPantuflas3.add(getColor(3L));
		coloresPantuflas3.add(getColor(1L));
		coloresPantuflas3.add(getColor(2L));
		
		List<Color> coloresPantuflas4 = new ArrayList<Color>();
		coloresPantuflas4.add(getColor(2L));
		coloresPantuflas4.add(getColor(0L));
		coloresPantuflas4.add(getColor(3L));
		
		List<Color> coloresPantuflas5 = new ArrayList<Color>();
		coloresPantuflas5.add(getColor(0L));
		
		
		List<Color> coloresPantuflas6 = new ArrayList<Color>();
		coloresPantuflas6.add(getColor(0L));
		coloresPantuflas6.add(getColor(2L));
		
		List<Color> coloresPantuflas7 = new ArrayList<Color>();
		coloresPantuflas7.add(getColor(1L));
		
		List<Color> coloresPantuflas8 = new ArrayList<Color>();
		coloresPantuflas8.add(getColor(0L));
		coloresPantuflas8.add(getColor(1L));
		coloresPantuflas8.add(getColor(2L));
		coloresPantuflas8.add(getColor(3L));
		
		Linea lineaPantuflasAbuelitas = new Linea();
		lineaPantuflasAbuelitas.setId(0L);
		lineaPantuflasAbuelitas.setLinea(Constantes.LINEA_PANTUFLAS_ABUELITAS);
		
		Linea lineaPantuflasCerradas = new Linea();
		lineaPantuflasCerradas.setId(0L);
		lineaPantuflasCerradas.setLinea(Constantes.LINEA_PANTUFLAS_CERRADAS);
		
		List<Talla> tallasPantuflas = new ArrayList<Talla>();
		tallasPantuflas.add(new Talla(0L,"35"));
		tallasPantuflas.add(new Talla(1L,"36"));
		tallasPantuflas.add(new Talla(2L,"37"));
		tallasPantuflas.add(new Talla(3L,"38"));
		tallasPantuflas.add(new Talla(4L,"39"));
		tallasPantuflas.add(new Talla(4L,"40"));
		tallasPantuflas.add(new Talla(4L,"41"));
		tallasPantuflas.add(new Talla(4L,"42"));
		tallasPantuflas.add(new Talla(4L,"43"));

		pantuflasHombre.add(new Producto(0L,"Pantuflas 1",Constantes.CATEGORIA_HOMBRE, new BigDecimal(15000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPantuflas1, lineaPantuflasAbuelitas, "Pantuflas para abuelitas", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pantuflas/hombre")));
		pantuflasHombre.add(new Producto(1L,"Pantuflas 2",Constantes.CATEGORIA_HOMBRE, new BigDecimal(15000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPantuflas2, lineaPantuflasCerradas, "Pantuflas cerradas para todo publico", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pantuflas/hombre")));
		pantuflasHombre.add(new Producto(2L,"Pantuflas 3",Constantes.CATEGORIA_HOMBRE, new BigDecimal(15000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPantuflas3, lineaPantuflasAbuelitas, "Pantuflas para abuelitas", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pantuflas/hombre")));
		pantuflasHombre.add(new Producto(3L,"Pantuflas 4",Constantes.CATEGORIA_HOMBRE, new BigDecimal(15000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPantuflas4, lineaPantuflasCerradas, "Pantuflas cerradas para todo publico", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pantuflas/hombre")));
		pantuflasHombre.add(new Producto(4L,"Pantuflas 5",Constantes.CATEGORIA_HOMBRE, new BigDecimal(15000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPantuflas5, lineaPantuflasAbuelitas, "Pantuflas para abuelitas", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pantuflas/hombre")));
		pantuflasHombre.add(new Producto(5L,"Pantuflas 6",Constantes.CATEGORIA_HOMBRE, new BigDecimal(15000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPantuflas6, lineaPantuflasCerradas, "Pantuflas cerradas para todo publico", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pantuflas/hombre")));
		pantuflasHombre.add(new Producto(6L,"Pantuflas 7",Constantes.CATEGORIA_HOMBRE, new BigDecimal(15000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPantuflas7, lineaPantuflasAbuelitas, "Pantuflas para abuelitas", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pantuflas/hombre")));
		pantuflasHombre.add(new Producto(7L,"Pantuflas 8",Constantes.CATEGORIA_HOMBRE, new BigDecimal(15000), "/img/categorias/hombres/pantuflas/productosHombre.jpg", coloresPantuflas8, lineaPantuflasCerradas, "Pantuflas cerradas para todo publico", "Tejido de punto", tallasPantuflas, new Item(0L,Constantes.ITEM_PANTUFLAS,"/img/categorias/hombres/productos/productosHombre.jpg", "/producto/pantuflas/hombre")));
		
		return pantuflasHombre;
	}

}
