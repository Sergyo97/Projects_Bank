package edu.eci.pdsw.samples.services.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.IdeaDAO;
import edu.eci.pdsw.sampleprj.dao.TipoIdeaDAO;
import edu.eci.pdsw.sampleprj.dao.UsuarioDAO;
import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.TipoIdea;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.BancoIniciativas;
import edu.eci.pdsw.samples.services.ExcepcionBancoIniciativas;

public class BancoIniciativasImpl implements BancoIniciativas{

	@Inject
	private TipoIdeaDAO tipoIdeaDao;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	private IdeaDAO ideaDAO;


	//USUARIOS
	public List<Usuario> consultarUsuarios() throws ExcepcionBancoIniciativas{
		try {
			return usuarioDAO.consultarUsuarios();
		} catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al consultar los usuarios", e);
		}
	};
	
	public List<Idea> consultarIdeasUsuario(String correo) throws ExcepcionBancoIniciativas {
		try {
			return ideaDAO.consultarIdeasUsuario(correo);
		} catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al consultar las ideas del usuario :" + correo, e);
		}
	};

	public Usuario consultarUsuario(String correo) throws ExcepcionBancoIniciativas{
		try {
			return usuarioDAO.consultarUsuario(correo);
		} catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al consultar el usuario :" + correo, e);
		}
	};

	public void agregarPropuestaUsuario(int id, String descripcion, String estado, Date fecha, int votos, String titulo, String usuario, TipoIdea tipoIdea) throws ExcepcionBancoIniciativas{
		try {
			ideaDAO.insertarIdea(new Idea(id, descripcion, estado, fecha, votos, titulo, usuario, tipoIdea));
		} catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al intentar ingresar la propuesta :" + titulo, e);
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
			throw new ExcepcionBancoIniciativas("Error al intentar insertar la idea :" + idea.getTitulo(), e);
		}
	};


	public List<Idea> consultarIdeas() throws ExcepcionBancoIniciativas{
		try {
			return ideaDAO.consultarIdeas();
		} catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al intentar consultar las ideas", e);
		}
	}
	
	
	public List<Idea> consultarPalabrasClave(String palabraClave) throws ExcepcionBancoIniciativas{
		try {
			return ideaDAO.consultarPalabrasClave(palabraClave);
		} catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al intentar consultar las ideas", e);
		}
	}

	
	public void actualizarEstado(String nuevoEstado, int id) throws ExcepcionBancoIniciativas{
		try {
			ideaDAO.actualizarEstado(nuevoEstado,id);
		} catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al intentar actualizar las ideas", e);
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

	//TRIGGERS
	
	@Override
	public int consultarId() throws ExcepcionBancoIniciativas {
		try {
			return ideaDAO.consultarid();
		}catch (Exception e) {
			throw new ExcepcionBancoIniciativas("Error al intentar consultar el ultimo id:", e);
		}		
	}
	
}
