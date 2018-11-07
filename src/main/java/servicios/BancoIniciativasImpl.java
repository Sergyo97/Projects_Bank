package servicios;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.google.inject.Inject;

import clasesJava.Idea;
import clasesJava.TipoIdea;
import clasesJava.Usuario;
import interfacesDAO.IdeaDAO;
import interfacesDAO.TipoIdeaDAO;
import interfacesDAO.TipoUsuarioDAO;
import interfacesDAO.UsuarioDAO;

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
		return null;
	};

	public void agregarPropuestaUsuario(int id,String nombre_iniciativa,String estado,	TipoIdea t_idea_id,int votos,Date fecha_creacion,TipoUsuario usuario_carne) throws PersistenceException{

	};
	
	public void insertarUsuario(Usuario usuario) {
		
		
	};

	
	//IDEAS
	
	public List<Idea> consultarIdeas(int id) throws PersistenceException{
		return null;
	};

	public void insertarIdea(Idea idea) throws PersistenceException{

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
