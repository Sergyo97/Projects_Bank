package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Votado;

public interface VotadoMapper {
	
	public void insertarVoto(@Param("correo")String correo,@Param("id") int id);

}
