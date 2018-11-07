package interfacesDAO;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import clasesJava.Idea;
import clasesJava.TipoIdea;
import clasesJava.TipoUsuario;

public interface IdeaDAO {

	public List<Idea> consultarIdeas() throws PersistenceException;
	
	public void insertarIdea(Idea idea) throws PersistenceException;
	
	public Idea consultarIdea(int id) throws PersistenceException;
	
}
