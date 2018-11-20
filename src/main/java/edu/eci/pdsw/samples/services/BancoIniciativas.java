package edu.eci.pdsw.samples.services;


import java.sql.Date;
import java.util.List;

import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.TipoIdea;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.entities.Votado;

public interface BancoIniciativas {
	
	//TRIGGERS
	public int consultarId() throws ExcepcionBancoIniciativas;
	

	//USUARIO
	public List<Usuario> consultarUsuarios() throws ExcepcionBancoIniciativas;
	
	public Usuario consultarUsuario(String correo) throws ExcepcionBancoIniciativas;
	
	public List<Idea> consultarIdeasUsuario(String correo) throws ExcepcionBancoIniciativas;

	public void agregarPropuestaUsuario(int id, String descripcion, String estado, Date fecha, int votos, String titulo, String usuario, TipoIdea tipoIdea) throws ExcepcionBancoIniciativas;

	public void insertarUsuario(Usuario usuario) throws ExcepcionBancoIniciativas;
	
	public Usuario consultarLogin(String correo, String contra) throws ExcepcionBancoIniciativas;


	//IDEAS
	public Idea consultarIdea(int id) throws ExcepcionBancoIniciativas;
	
	public void insertarIdea(Idea idea) throws ExcepcionBancoIniciativas;

	public List<Idea> consultarIdeas() throws ExcepcionBancoIniciativas;
	
	public void actualizarVoto(int id,String correo) throws ExcepcionBancoIniciativas;
	
	
	//VOTADOS
	public void insertarVoto(int id,String correo) throws ExcepcionBancoIniciativas;


	//TipoIdeas
	public List<TipoIdea> consultarTipoIdeas() throws ExcepcionBancoIniciativas;

	public TipoIdea consultarTipoIdea(int id) throws ExcepcionBancoIniciativas;

	public void insertarTipoIdea(TipoIdea ti) throws ExcepcionBancoIniciativas;

}
