package Mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import clasesJava.TipoUsuario;

public interface TipoUsuarioMapper {
	
	public List<TipoUsuario> consultarTiposUsuario();
    
    public TipoUsuario getTipoUsuario(@Param("id")int id);
    
    public void addTipoUsuario(@Param("tUsuario")TipoUsuario tUsuario);

}
