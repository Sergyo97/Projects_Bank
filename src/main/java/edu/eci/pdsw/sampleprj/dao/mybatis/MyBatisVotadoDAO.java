package edu.eci.pdsw.sampleprj.dao.mybatis;

import javax.persistence.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.VotoDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.VotadoMapper;
import edu.eci.pdsw.samples.entities.Votado;

public class MyBatisVotadoDAO implements VotoDAO{
	
	@Inject
	private VotadoMapper votadoMapper;

	@Override
	public void insertarVoto(int id, String correo) throws PersistenceException {
		try {
			votadoMapper.insertarVoto(correo,id);
		} catch (Exception e) {
			throw new PersistenceException("Error al registrar voto", e);
		}
	}	

}
