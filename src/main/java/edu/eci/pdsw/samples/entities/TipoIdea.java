package edu.eci.pdsw.samples.entities;

import java.io.Serializable;

public class TipoIdea implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String tipo;
	
	public TipoIdea(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	
	public TipoIdea() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "TipoIdea [id=" + id + ", tipo=" + tipo + "]";
	}
	
}
