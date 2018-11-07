package clasesDao;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.google.inject.Inject;

import Mappers.IdeaMapper;
import clasesJava.Idea;
import clasesJava.TipoIdea;
import clasesJava.TipoUsuario;
import interfacesDAO.IdeaDAO;

public class MyBatisIdeaDAO implements IdeaDAO {

	
	@Inject
	private IdeaMapper ideaMapper;
	
	@Override
	public Idea consultarIdea(int id) throws PersistenceException {
		return ideaMapper.consultarIdea(id);
	}

	@Override
	public void insertarIdea(Idea idea) throws PersistenceException {
		ideaMapper.insertarIdea(idea);
	}

	@Override
	public List<Idea> consultarIdeas() throws PersistenceException {
		return ideaMapper.consultarIdeas();
	}
	
}
