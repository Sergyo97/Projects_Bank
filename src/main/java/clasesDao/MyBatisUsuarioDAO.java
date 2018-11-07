package clasesDao;

import java.util.Date;

import javax.persistence.PersistenceException;

import com.google.inject.Inject;

import Mappers.UsuarioMapper;
import clasesJava.TipoIdea;
import clasesJava.TipoUsuario;
import clasesJava.Usuario;
import interfacesDAO.UsuarioDAO;

public class MyBatisUsuarioDAO implements UsuarioDAO {

	
	
	@Inject
	private UsuarioMapper usuarioMapper;
	
	@Override
	public Usuario consultarUsuario(int id) throws PersistenceException {
		return usuarioMapper.consultarUsuario(id);
	}

	

	@Override
	public void insertarUsuario(Usuario usuario) {
		usuarioMapper.insertarUsuario(usuario);
		
	}

}
