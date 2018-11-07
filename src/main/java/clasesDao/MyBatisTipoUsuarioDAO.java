package clasesDao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import Mappers.TipoUsuarioMapper;
import clasesJava.TipoUsuario;
import interfacesDAO.TipoUsuarioDAO;

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
