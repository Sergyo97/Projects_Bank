package clasesDao;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import clasesJava.Idea;
import clasesJava.TipoIdea;
import clasesJava.TipoUsuario;
import interfacesDAO.IdeaDAO;

public class MyBatisIdeaDAO implements IdeaDAO {

	@Override
	public List<Idea> consultarIdeas(int id) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarIdea(Idea idea) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarPropuestaUsuario(int id, String nombre_iniciativa, String estado, TipoIdea t_idea_id, int votos,
			Date fecha_creacion, TipoUsuario usuario_carne) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

}
