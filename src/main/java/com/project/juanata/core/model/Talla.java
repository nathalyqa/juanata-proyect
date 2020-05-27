package com.project.juanata.core.model;

public class Talla {
	
	private Long id;
	private String talla;
	
	public Talla(Long id, String talla) {
		this.id = id;
		this.talla = talla;
	}
	
	public Talla() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
}
