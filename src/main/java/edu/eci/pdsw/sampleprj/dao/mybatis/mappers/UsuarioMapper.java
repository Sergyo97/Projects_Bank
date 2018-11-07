package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Usuario;

public interface UsuarioMapper {
	
	    public Usuario consultarUsuario(@Param("idus")int id); 
	    
	    public void insertarUsuario(@Param("usuario") Usuario us);

	}


