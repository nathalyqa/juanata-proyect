package com.project.juanata.core.model;

import java.math.BigDecimal;
import java.util.List;

public class Producto {
	
	private Long id;
	private String nombre;
	//Especifica si es producto Mujer, Hombre, Niño ó Niña
	private String categoria;
	private BigDecimal precio;
	private String nombreFoto;
	private List<Color> colores;
	private Linea linea;
	private String descripcion;
	private String material;
	private List<Talla> tallas;
	//A que item pertenece, Pijama, Pantuflas, Chaquetas, Blodys, etc.
	private Item item;
	
	
	public Producto(Long id, String nombre, String categoria, BigDecimal precio, String nombreFoto,
			List<Color> colores, Linea linea, String descripcion, String material, List<Talla> tallas, Item item) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.nombreFoto = nombreFoto;
		this.colores = colores;
		this.linea = linea;
		this.descripcion = descripcion;
		this.material = material;
		this.tallas = tallas;
		this.item = item;
	}
	
	public Producto() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public String getNombreFoto() {
		return nombreFoto;
	}
	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}

	public List<Color> getColores() {
		return colores;
	}

	public void setColores(List<Color> colores) {
		this.colores = colores;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public List<Talla> getTallas() {
		return tallas;
	}

	public void setTallas(List<Talla> tallas) {
		this.tallas = tallas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
