package interfacesDAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import clasesJava.TipoUsuario;

public interface TipoUsuarioDAO {

	public List<TipoUsuario> consultarTiposItem();

	public TipoUsuario getTipoItem(int id);

	public void addTipoItem(TipoUsuario tUsuario);
}
