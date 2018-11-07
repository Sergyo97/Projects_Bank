package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Idea;



public interface IdeaMapper {

	public List<Idea> consultarIdeas();
	
	public void insertarIdea(@Param("Idea") Idea idea);
	
	public Idea consultarIdea(@Param("id")int id);

}
