package com.project.juanata.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TALLA")
public class Talla implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String talla;

	public Talla(Integer id, String talla) {
		super();
		this.id = id;
		this.talla = talla;
	}

	public Talla(String talla) {
		super();
		this.talla = talla;
	}

	public Talla() {
		super();
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

	@Override
	public String toString() {
		return "Talla [id=" + id + ", talla=" + talla + "]";
	}

}
