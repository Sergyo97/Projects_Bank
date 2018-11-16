package edu.eci.pdsw.samples.entities;

import java.util.ArrayList;

public class Votado {

	
	private ArrayList<Idea> ideas;
	private Usuario usuario;
	
	
	public Votado(ArrayList<Idea> ideas, Usuario usuario) {
		super();
		this.ideas = ideas;
		this.usuario = usuario;
	}

	public Votado() {
		
	}

	public ArrayList<Idea> getIdeas() {
		return ideas;
	}


	public void setIdeas(ArrayList<Idea> ideas) {
		this.ideas = ideas;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		return "Votado [ideas=" + ideas + ", usuario=" + usuario + "]";
	}
	
}
