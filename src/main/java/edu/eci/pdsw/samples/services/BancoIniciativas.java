package edu.eci.pdsw.samples.services;

import java.util.Date;
import java.util.List;

import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.TipoIdea;
import edu.eci.pdsw.samples.entities.TipoUsuario;
import edu.eci.pdsw.samples.entities.Usuario;

public interface BancoIniciativas {

	//USUARIO
	public List<Usuario> consultarUsuarios() throws ExcepcionBancoIniciativas;
	
	public Usuario consultarUsuario(int id) throws ExcepcionBancoIniciativas;

	public void agregarPropuestaUsuario(int id,String nombre_iniciativa,String estado,	TipoIdea t_idea_id,int votos,Date fecha_creacion,int usuario_carne, String descripcion) throws ExcepcionBancoIniciativas;

	public void insertarUsuario(Usuario usuario) throws ExcepcionBancoIniciativas;


	//IDEAS
	public Idea consultarIdea(int id) throws ExcepcionBancoIniciativas;
	
	public void insertarIdea(Idea idea) throws ExcepcionBancoIniciativas;


	public List<Idea> consultarIdeas() throws ExcepcionBancoIniciativas;


	//TipoIdeas
	public List<TipoIdea> consultarTipoIdeas() throws ExcepcionBancoIniciativas;

	public TipoIdea consultarTipoIdea(int id) throws ExcepcionBancoIniciativas;

	public void insertarTipoIdea(TipoIdea ti) throws ExcepcionBancoIniciativas;


	//TipoUsuarios
	public List<TipoUsuario> consultarTiposUsuario() throws ExcepcionBancoIniciativas;

	public TipoUsuario consultarTipoUsuario(int id) throws ExcepcionBancoIniciativas;

}
