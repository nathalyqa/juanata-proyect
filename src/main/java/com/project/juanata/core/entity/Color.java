package com.project.juanata.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COLOR")
public class Color implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//El nombre de la clase de color creada en CSS
	private String claseColor;
	
	private String color;

	public Color(Integer id, String claseColor, String color) {
		super();
		this.id = id;
		this.claseColor = claseColor;
		this.color = color;
	}

	public Color(String claseColor, String color) {
		super();
		this.claseColor = claseColor;
		this.color = color;
	}

	public Color() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getClaseColor() {
		return claseColor;
	}

	public void setClaseColor(String claseColor) {
		this.claseColor = claseColor;
	}

	@Override
	public String toString() {
		return "Color [id=" + id + ", claseColor=" + claseColor + ", color=" + color + "]";
	}
}
