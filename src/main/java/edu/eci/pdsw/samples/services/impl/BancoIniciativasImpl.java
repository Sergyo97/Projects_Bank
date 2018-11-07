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
import edu.eci.pdsw.samples.services.ExcepcionBancoIniciativas;

public class BancoIniciativasImpl {

	@Inject
	private TipoIdeaDAO tipoIdeaDao;

	@Inject
	private TipoUsuarioDAO tipoUsuarioDAO;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	private IdeaDAO ideaDAO;


	//USUARIOS

		public Usuario consultarUsuario(int id) throws ExcepcionBancoIniciativas{
			try {
				return usuarioDAO.consultarUsuario(id);
			} catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al consultar el usuario :" + id, e);
			}
		};

		public void agregarPropuestaUsuario(int id,String nombre_iniciativa,String estado,	TipoIdea t_idea_id,int votos,Date fecha_creacion,int usuario_carne) throws ExcepcionBancoIniciativas{
			try {
				ideaDAO.insertarIdea(new Idea(id, nombre_iniciativa, estado, t_idea_id, votos, fecha_creacion, usuario_carne));
			} catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al intentar ingresar la propuesta :" + nombre_iniciativa, e);
			}
		};
		
		public void insertarUsuario(Usuario usuario) throws ExcepcionBancoIniciativas{		
			try {
				usuarioDAO.insertarUsuario(usuario);
			} catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al intentar ingresar el usuario :" + usuario.getNombre(), e);
			}
		};

		
		//IDEAS
		
		public Idea consultarIdea(int id) throws ExcepcionBancoIniciativas{
			try {
				return ideaDAO.consultarIdea(id);
			} catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al intentar cosnultar la idea :" + id, e);
			}
		};

		public void insertarIdea(Idea idea) throws ExcepcionBancoIniciativas{
			try {
				ideaDAO.insertarIdea(idea);
			} catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al intentar insertar la idea :" + idea.getnombreIniciativa(), e);
			}
		};
		
		
		public List<Idea> consultarIdeas() throws ExcepcionBancoIniciativas{
			try {
				return ideaDAO.consultarIdeas();
			} catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al intentar consultar las ideas", e);
			}
		}
		
		
		//TipoIdeas

		public List<TipoIdea> consultarTipoIdeas() throws ExcepcionBancoIniciativas{
			try {
				return tipoIdeaDao.consultarTipoIdeas();
			} catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al intentar consultar los tipos de ideas", e);
			}
		};

		public TipoIdea consultarTipoIdea(int id) throws ExcepcionBancoIniciativas{
			try {
				return tipoIdeaDao.getTipoIdea(id);
			} catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al intentar consultar el tipo idea: "+ id, e);
			}
		};

		public void insertarTipoIdea(TipoIdea ti) throws ExcepcionBancoIniciativas{
			try {
				tipoIdeaDao.addTipoIdea(ti);
			} catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al intentar insertar el tipo idea: "+ ti.getTipo(), e);
			}
		};

		
		//TipoUsuarios

		public List<TipoUsuario> consultarTiposUsuario() throws ExcepcionBancoIniciativas{
			try {
				return tipoUsuarioDAO.consultarTiposUsuario();
			} catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al intentar consultar los tipos de usuario", e);
			}
		};

		public TipoUsuario consultarTipoUsuario(int id) throws ExcepcionBancoIniciativas{
			try {
				return tipoUsuarioDAO.getTipoUsuario(id);
			} catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al intentar consultar el tipo de usuario: "+id, e);
			}
		};
}
