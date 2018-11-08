package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.Date;

public class Idea implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String nombreIniciativa;
	String estado;
	TipoIdea tIdeaId;
	int votos;
	Date fechaCreacion;
	int usuarioCarne;
	String descripcion;

	
	
	public Idea(int id, String nombreIniciativa, String estado, TipoIdea tIdeaId, int votos, Date fechaCreacion, int usuarioCarne, String descripcion) {
		this.id = id;
		this.nombreIniciativa = nombreIniciativa;
		this.estado = estado;
		this.tIdeaId = tIdeaId;
		this.votos = votos;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCarne = usuarioCarne;
		this.descripcion = descripcion;
	}

	public Idea() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getnombreIniciativa() {
		return nombreIniciativa;
	}

	public void setnombreIniciativa(String nombreIniciativa) {
		this.nombreIniciativa = nombreIniciativa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public TipoIdea gettIdeaId() {
		return tIdeaId;
	}

	public void settIdeaId(TipoIdea tIdeaId) {
		this.tIdeaId = tIdeaId;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public Date getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getusuarioCarne() {
		return usuarioCarne;
	}

	public void setusuarioCarne(int usuarioCarne) {
		this.usuarioCarne = usuarioCarne;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Idea [id=" + id + ", nombreIniciativa=" + nombreIniciativa + ", estado=" + estado + ", tIdeaId="
				+ tIdeaId + ", votos=" + votos + ", fechaCreacion=" + fechaCreacion + ", usuarioCarne=" + usuarioCarne
				+ ", descripcion=" + descripcion + "]";
	}
}
