package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Votado;

public interface VotadoMapper {
	
	public void insertarVoto(@Param("correo")String correo,@Param("id") int id);
	
	public List<Votado> consultarVotosIdea(@Param("id")int id);

}
