package com.project.juanata.core.model;

public class Item {
	
	private Long id;
	private String nombreItem;
	private String rutaFoto;
	private String link;
	
	public Item(Long id, String nombreItem, String rutaFoto, String link) {
		this.id = id;
		this.nombreItem = nombreItem;
		this.rutaFoto = rutaFoto;
		this.link = link;
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
	public String getRutaFoto() {
		return rutaFoto;
	}
	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
