package interfacesDAO;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import clasesJava.Idea;
import clasesJava.TipoIdea;
import clasesJava.TipoUsuario;

public interface IdeaDAO {

	public List<Idea> consultarIdeas(int id) throws PersistenceException;
	public void insertarIdea(Idea idea) throws PersistenceException;
	public void agregarPropuestaUsuario(int id,String nombre_iniciativa,String estado,	TipoIdea t_idea_id,int votos,Date fecha_creacion,TipoUsuario usuario_carne) throws PersistenceException;
}
