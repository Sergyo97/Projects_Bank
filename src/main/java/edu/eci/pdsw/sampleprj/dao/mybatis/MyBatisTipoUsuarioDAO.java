package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.TipoUsuarioDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoUsuarioMapper;
import edu.eci.pdsw.samples.entities.TipoUsuario;

public class MyBatisTipoUsuarioDAO implements TipoUsuarioDAO {
	
	@Inject
	private TipoUsuarioMapper tipoUsuarioMapper;
	

	@Override
	public List<TipoUsuario> consultarTiposUsuario() {
		
		return tipoUsuarioMapper.consultarTiposUsuario();
		
	}

	@Override
	public TipoUsuario getTipoUsuario(int id) {
		try {
			return tipoUsuarioMapper.getTipoUsuario(id);
		} catch (Exception e) {
			throw new PersistenceException("Error al consultar tipo usuario :" + id, e);
		}
	}

}
