package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String correo;
	private String nombre;
	private String clave;
	private boolean activo;
	private TipoUsuario tipo;
	private ArrayList<Idea> ideas;
	
	public Usuario(String correo, String nombre, String clave, boolean activo, TipoUsuario tipo,
			ArrayList<Idea> ideas) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.clave = clave;
		this.activo = activo;
		this.tipo = tipo;
		this.ideas = ideas;
	}
	
	public Usuario() {
		
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(ArrayList<Idea> ideas) {
		this.ideas = ideas;
	}

	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", nombre=" + nombre + ", clave=" + clave + ", activo=" + activo
				+ ", tipo=" + tipo + ", ideas=" + ideas + "]";
	}
	
}
