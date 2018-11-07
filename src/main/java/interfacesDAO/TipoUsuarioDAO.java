package interfacesDAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import clasesJava.TipoIdea;
import clasesJava.TipoUsuario;

public interface TipoUsuarioDAO {

	public List<TipoUsuario> consultarTiposUsuario();

	public TipoUsuario getTipoUsuario(int id);
}
