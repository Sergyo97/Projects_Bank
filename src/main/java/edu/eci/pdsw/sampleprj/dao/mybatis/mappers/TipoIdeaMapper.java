package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.TipoIdea;

public interface TipoIdeaMapper {
	
	public List<TipoIdea> consultarTipoIdeas();
    
    public TipoIdea getTipoIdea(@Param("id")int id);
    
    public void addTipoIdea(@Param("ti")TipoIdea ti);

}
