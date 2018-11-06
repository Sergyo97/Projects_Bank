package Mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import clasesJava.TipoUsuario;

public interface tipoUsuarioMapper {
	
	public List<TipoUsuario> consultarTiposItem();
    
    public TipoUsuario getTipoItem(@Param("id")int id);
    
    public void addTipoItem(@Param("tUsuario")TipoUsuario tUsuario);

}
