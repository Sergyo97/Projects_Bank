package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Usuario;

public interface UsuarioMapper {

	public Usuario consultarUsuario(@Param("correo")String correo); 

	public void insertarUsuario(@Param("usuario") Usuario us);

	public List<Usuario> consultarUsuarios();

	public Usuario consultarLogin(@Param("correo")String correo,@Param("contraseña")String contra);

}


