package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.Date;

public class Idea implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String descripcion;
	private String estado;
	private Date fecha;
	private int votos;
	private String titulo;
	private String usuario;
	private TipoIdea tipoIdea;
	
	public Idea(int id, String descripcion, String estado, Date fecha, int votos, String titulo, String usuario,
			TipoIdea tipoIdea) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fecha = fecha;
		this.votos = votos;
		this.titulo = titulo;
		this.usuario = usuario;
		this.tipoIdea = tipoIdea;
	}
	
	public Idea() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public TipoIdea getTipoIdea() {
		return tipoIdea;
	}

	public void setTipoIdea(TipoIdea tipoIdea) {
		this.tipoIdea = tipoIdea;
	}

	@Override
	public String toString() {
		return "Idea [id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", fecha=" + fecha
				+ ", votos=" + votos + ", titulo=" + titulo + ", usuario=" + usuario + ", tipoIdea=" + tipoIdea + "]";
	}
	
}
