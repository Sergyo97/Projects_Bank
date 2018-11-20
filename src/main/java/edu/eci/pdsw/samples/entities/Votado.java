package edu.eci.pdsw.samples.entities;

import java.util.Date;

public class Votado {

	
	private Idea ideas;
	private Usuario usuario;
	private Date fecha;
	
	
	public Votado(Idea ideas, Usuario usuario, Date fecha) {
		super();
		this.ideas = ideas;
		this.usuario = usuario;
		this.fecha = fecha;
	}

	public Votado() {
		
	}

	public Idea getIdeas() {
		return ideas;
	}

	public void setIdeas(Idea ideas) {
		this.ideas = ideas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Votado [ideas=" + ideas + ", usuario=" + usuario + ", fecha=" + fecha + "]";
	}
	
}
