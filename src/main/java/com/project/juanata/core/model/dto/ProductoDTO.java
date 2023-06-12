package com.project.juanata.core.model.dto;

import java.math.BigDecimal;
import java.util.List;

public class ProductoDTO {
	
	private Integer id;
	private String nombre;
	//Especifica si es producto Mujer, Hombre, Niño ó Niña
	private String categoria;
	private BigDecimal precio;
	private String rutaFoto;
	private List<ColorDTO> colores;
	private LineaDTO linea;
	private String descripcion;
	private String material;
	private List<TallaDTO> tallas;
	//A que item pertenece, Pijama, Pantuflas, Chaquetas, Blodys, etc.
	private ItemDTO item;
	
	
	public ProductoDTO(Integer id, String nombre, String categoria, BigDecimal precio, String rutaFoto,
			List<ColorDTO> colores, LineaDTO linea, String descripcion, String material, List<TallaDTO> tallas, ItemDTO item) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.rutaFoto = rutaFoto;
		this.colores = colores;
		this.linea = linea;
		this.descripcion = descripcion;
		this.material = material;
		this.tallas = tallas;
		this.item = item;
	}

	public ProductoDTO(String nombre, String categoria, BigDecimal precio, String rutaFoto, List<ColorDTO> colores,
			LineaDTO linea, String descripcion, String material, List<TallaDTO> tallas, ItemDTO item) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.rutaFoto = rutaFoto;
		this.colores = colores;
		this.linea = linea;
		this.descripcion = descripcion;
		this.material = material;
		this.tallas = tallas;
		this.item = item;
	}
	
	public ProductoDTO() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getRutaFoto() {
		return rutaFoto;
	}
	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	public List<ColorDTO> getColores() {
		return colores;
	}

	public void setColores(List<ColorDTO> colores) {
		this.colores = colores;
	}

	public LineaDTO getLinea() {
		return linea;
	}

	public void setLinea(LineaDTO linea) {
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

	public List<TallaDTO> getTallas() {
		return tallas;
	}

	public void setTallas(List<TallaDTO> tallas) {
		this.tallas = tallas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public ItemDTO getItem() {
		return item;
	}

	public void setItem(ItemDTO item) {
		this.item = item;
	}
}
