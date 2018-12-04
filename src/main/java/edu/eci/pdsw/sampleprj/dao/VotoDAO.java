package edu.eci.pdsw.sampleprj.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import edu.eci.pdsw.samples.entities.Votado;

public interface VotoDAO {
	
	public void insertarVoto(int id,String correo) throws PersistenceException;
	
	public List<Votado> consultarVotosIdea(int id) throws PersistenceException;

	public boolean consultarVotoPorEstaIdea(int id, String correo);

	public void eliminarVoto(int id, String correo);

}
