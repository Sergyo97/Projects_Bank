package edu.eci.pdsw.sampleprj.dao;

import javax.persistence.PersistenceException;

import edu.eci.pdsw.samples.entities.Votado;

public interface VotoDAO {
	
	public void insertarVoto(int id,String correo) throws PersistenceException;
	
	public Votado consultarVotosIdea(int id) throws PersistenceException;

}
