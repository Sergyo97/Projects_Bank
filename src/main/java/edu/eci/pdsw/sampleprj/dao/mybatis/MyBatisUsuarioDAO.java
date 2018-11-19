package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

import javax.persistence.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.UsuarioDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.pdsw.samples.entities.Usuario;

public class MyBatisUsuarioDAO implements UsuarioDAO {	
	
	@Inject
	private UsuarioMapper usuarioMapper;
	
	@Override
	public Usuario consultarUsuario(String correo) throws PersistenceException {
		return usuarioMapper.consultarUsuario(correo);
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
	public Usuario consultarLogin(String correo, String contra) throws PersistenceException {
		return usuarioMapper.consultarLogin(correo, contra);
	}

}
