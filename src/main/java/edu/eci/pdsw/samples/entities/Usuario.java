package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	String correo;
	long carne;
	TipoUsuario tipoUsuarioId;
	boolean activo;
	ArrayList<Idea> ideasDeUsuario;

	
	public Usuario(String nombre, String correo, long carne, TipoUsuario tipoUsuarioId, boolean activo, ArrayList<Idea> ideasDeUsuario) {
		this.nombre = nombre;
		this.correo = correo;
		this.carne = carne;
		this.tipoUsuarioId = tipoUsuarioId;
		this.activo = activo;
		this.ideasDeUsuario = ideasDeUsuario;
	}
	
	public Usuario() {
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public long getCarne() {
		return carne;
	}
	
	public void setCarne(long carne) {
		this.carne = carne;
	}
	
	public TipoUsuario gettipoUsuarioId() {
		return tipoUsuarioId;
	}
	
	public void settipoUsuarioId(TipoUsuario tipoUsuarioId) {
		this.tipoUsuarioId = tipoUsuarioId;
	}
	
	public boolean isActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public ArrayList<Idea> getIdeasDeUsuario() {
		return ideasDeUsuario;
	}
	
	public void setIdeasDeUsuario(ArrayList<Idea> ideasDeUsuario) {
		this.ideasDeUsuario = ideasDeUsuario;
	}

	@Override
	public String toString() {
		return "usuario [nombre=" + nombre + ", correo=" + correo + ", carne=" + carne + ", tipoUsuarioId=" + tipoUsuarioId
				+ ", activo=" + activo + "]";
	}

	
	

}
