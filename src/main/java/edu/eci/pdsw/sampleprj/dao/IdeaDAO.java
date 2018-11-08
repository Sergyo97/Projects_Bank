package edu.eci.pdsw.sampleprj.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import edu.eci.pdsw.samples.entities.Idea;

public interface IdeaDAO {

	public List<Idea> consultarIdeas() throws PersistenceException;
	
	public void insertarIdea(Idea idea) throws PersistenceException;
	
	public Idea consultarIdea(int id) throws PersistenceException;
	
	public List<Idea> consultarPalabrasClave(String palabraClave) throws PersistenceException;
	
	public void actualizarEstado (String nuevoEstado, int id) throws PersistenceException;
	
	
}
