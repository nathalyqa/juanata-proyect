package com.project.juanata.core.model.dto;

public class ItemDTO {
	
	private Integer id;
	private String nombreItem;
	private String rutaFoto;
	private String link;
	
	public ItemDTO(Integer id, String nombreItem, String rutaFoto, String link) {
		this.id = id;
		this.nombreItem = nombreItem;
		this.rutaFoto = rutaFoto;
		this.link = link;
	}
	
	public ItemDTO() {
	}

	public ItemDTO(String nombreItem, String rutaFoto, String link) {
		super();
		this.nombreItem = nombreItem;
		this.rutaFoto = rutaFoto;
		this.link = link;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
