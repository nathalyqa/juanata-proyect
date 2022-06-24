package com.project.juanata.core.model;

public class Item {
	
	private Long id;
	private String nombreItem;
	private String nombreFoto;
	//Indica si pertenece a la categoria, Mujer, Hombre, Niño o Niña.
	private String categoria;
	
	public Item(Long id, String nombreItem, String nombreFoto, String categoria) {
		this.id = id;
		this.nombreItem = nombreItem;
		this.nombreFoto = nombreFoto;
		this.categoria = categoria;
	}
	
	public Item() {
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreItem() {
		return nombreItem;
	}
	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}
	public String getNombreFoto() {
		return nombreFoto;
	}
	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
