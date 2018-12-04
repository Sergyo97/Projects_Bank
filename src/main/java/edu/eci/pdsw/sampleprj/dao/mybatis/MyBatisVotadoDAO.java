package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

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
	
	@Override
	public void eliminarVoto(int id, String correo) {
		votadoMapper.borrarVoto(correo,id);
		
	}	

	@Override
	public List<Votado> consultarVotosIdea(int id) throws PersistenceException {
		try {
			return votadoMapper.consultarVotosIdea(id);
		} catch (Exception e) {
			throw new PersistenceException("Error al consultar voto", e);
		}
	}

	@Override
	public boolean consultarVotoPorEstaIdea(int id, String correo)  throws PersistenceException {
		try {
			if (votadoMapper.consultarVotoPorEstaIdea(id,correo) == 1) {
				return true;
			}else { 
				return false;
			}
		}catch (Exception e) {
			throw new PersistenceException("Error al consultar voto", e);
		}

	}

	

}
