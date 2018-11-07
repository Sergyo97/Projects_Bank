package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.TipoIdea;
import edu.eci.pdsw.samples.entities.TipoUsuario;

public interface TipoIdeaMappers {
	
	public List<TipoIdea> consultarTipoIdeas();
    
    public TipoIdea getTipoIdea(@Param("id")int id);
    
    public void addTipoIdea(@Param("ti")TipoIdea ti);

}
