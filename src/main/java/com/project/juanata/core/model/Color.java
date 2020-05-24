package com.project.juanata.core.model;

public class Color {
	
	private Long id;
	private String claseColor;
	
	public Color(Long id, String claseColor) {
		this.id = id;
		this.claseColor = claseColor;
	}
	
	public Color() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClaseColor() {
		return claseColor;
	}
	public void setClaseColor(String claseColor) {
		this.claseColor = claseColor;
	}
}
