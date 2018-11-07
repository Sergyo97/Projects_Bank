package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.TipoUsuario;

public interface TipoUsuarioMapper {
	
	public List<TipoUsuario> consultarTiposUsuario();
    
    public TipoUsuario getTipoUsuario(@Param("id")int id);
    
    public void addTipoUsuario(@Param("tUsuario")TipoUsuario tUsuario);

}
