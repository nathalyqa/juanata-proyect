package com.project.juanata.core.model.dto;

public class ColorDTO {
	
	private Integer id;
	//El nombre de la clase de color creada en CSS
	private String claseColor;
	private String color;
	
	public ColorDTO(Integer id, String claseColor, String color) {
		this.id = id;
		this.claseColor = claseColor;
		this.color = color;
	}
	
	public ColorDTO() {
	}

	public ColorDTO(String claseColor, String color) {
		super();
		this.claseColor = claseColor;
		this.color = color;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
