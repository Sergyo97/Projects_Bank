package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Votado;

public interface VotadoMapper {
	
	public void insertarVoto(@Param("correo")String correo,@Param("id") int id);
	
	public void borrarVoto(@Param("correo")String correo,@Param("id") int id);
	
	public List<Votado> consultarVotosIdea(@Param("id")int id);

	public int consultarVotoPorEstaIdea(@Param("id") int id,@Param("correo") String correo);

	

}
