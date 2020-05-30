package com.project.juanata.core.model;

public class Color {
	
	private Long id;
	//El nombre de la clase de color creada en CSS
	private String claseColor;
	private String color;
	
	public Color(Long id, String claseColor, String color) {
		this.id = id;
		this.claseColor = claseColor;
		this.color = color;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
