package com.project.juanata.core.model.dto;

public class LineaDTO {
	
	private Integer id;
	private String linea;

	public LineaDTO(Integer id, String linea) {
		super();
		this.id = id;
		this.linea = linea;
	}

	public LineaDTO() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
}
