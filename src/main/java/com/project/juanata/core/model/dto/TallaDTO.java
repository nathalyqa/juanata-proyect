package com.project.juanata.core.model.dto;

public class TallaDTO {
	
	private Integer id;
	private String talla;
	
	public TallaDTO(Integer id, String talla) {
		this.id = id;
		this.talla = talla;
	}
	
	public TallaDTO() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
}
