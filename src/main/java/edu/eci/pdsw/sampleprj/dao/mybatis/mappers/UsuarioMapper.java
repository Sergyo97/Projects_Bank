package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.Usuario;

public interface UsuarioMapper {
	
	    public Usuario consultarUsuario(@Param("cus")long carne); 
	    
	    public void insertarUsuario(@Param("usuario") Usuario us);
	    
	    public List<Usuario> consultarUsuarios();

		public Usuario ConsultarUsuarioPorCorreo(@Param("correo") String correo);	    

	}


