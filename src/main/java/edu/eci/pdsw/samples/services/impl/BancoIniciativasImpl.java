package edu.eci.pdsw.samples.services.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.IdeaDAO;
import edu.eci.pdsw.sampleprj.dao.TipoIdeaDAO;
import edu.eci.pdsw.sampleprj.dao.TipoUsuarioDAO;
import edu.eci.pdsw.sampleprj.dao.UsuarioDAO;
import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.TipoIdea;
import edu.eci.pdsw.samples.entities.TipoUsuario;
import edu.eci.pdsw.samples.entities.Usuario;

public class BancoIniciativasImpl {

	@Inject
	private TipoIdeaDAO tipoIdeaDao;

	@Inject
	private TipoUsuarioDAO tipoUsuarioDAO;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	private IdeaDAO ideaDAO;


	//CLIENTES

	public Usuario consultarUsuario(int id) throws PersistenceException{
		try {

		} catch (Exception e) {

		}
		return null;
	};

	public void agregarPropuestaUsuario(int id,String nombre_iniciativa,String estado,	TipoIdea t_idea_id,int votos,Date fecha_creacion,TipoUsuario usuario_carne) throws PersistenceException{

	};

	public void insertarUsuario(Usuario usuario) {


	};


	//IDEAS

	public Idea consultarIdea(int id) throws PersistenceException{
		return null;
	};

	public void insertarIdea(Idea idea) throws PersistenceException{

	};

	public List<Idea> consultarIdeas() throws PersistenceException{
		return null;
	};


	//TipoIdeas

	public List<TipoIdea> consultarTipoIdeas(){
		return null;
	};

	public TipoIdea getTipoIdea(int id) {
		return null;
	};

	public void addTipoItem(TipoIdea ti) {

	};


	//TipoUsuarios

	public List<TipoUsuario> consultarTiposItem(){
		return null;
	};

	public TipoUsuario getTipoItem(int id) {
		return null;
	};

	public void addTipoItem(TipoUsuario tUsuario) {

	};



}
