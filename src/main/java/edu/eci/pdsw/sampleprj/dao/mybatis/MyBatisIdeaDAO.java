package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

import javax.persistence.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.IdeaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.IdeaMapper;
import edu.eci.pdsw.samples.entities.Idea;

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