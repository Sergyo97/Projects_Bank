package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

import javax.persistence.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.UsuarioDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.Usuario;

public class MyBatisUsuarioDAO implements UsuarioDAO {	
	
	@Inject
	private UsuarioMapper usuarioMapper;
	
	@Override
	public Usuario consultarUsuario(long carne) throws PersistenceException {
		return usuarioMapper.consultarUsuario(carne);
	}

	@Override
	public void insertarUsuario(Usuario usuario) {
		usuarioMapper.insertarUsuario(usuario);
	}
	
	@Override
	public List<Usuario> consultarUsuarios() {
		return usuarioMapper.consultarUsuarios();
	}

	@Override
	public List<Idea> consultarIdeasUsuario(int carne) throws PersistenceException {
		try {
			return usuarioMapper.consultarIdeasUsuario(carne);
		} catch (Exception e) {
			throw new PersistenceException("Error al consultar tipo usuario", e);
		}
		
	}

}
