package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Idea;



public interface IdeaMapper {

	public List<Idea> consultarIdeas();

	public void insertarIdea(@Param("Idea") Idea idea);

	public Idea consultarIdea(@Param("id")int id);

	public List<Idea> consultarPalabrasClave(@Param("clave") String clave);	

	public void actualizarEstado(@Param("nEstado") String nuevoEstado, @Param("id") int id);

	public List<Idea> consultarIdeasUsuario(@Param("correo")String correo);

	public Idea consultarId();

	public void actualizarVoto(@Param("id")int id, @Param("correo") String correo);
	
	
	
	public void ponerVoto(@Param("id")int id, @Param("correo") String correo);
	
	public void quitarVoto(@Param("id")int id, @Param("correo") String correo);

	public void modificarDescripcion(@Param("id")int id, @Param("descripcion") String descripcion);
	
}
