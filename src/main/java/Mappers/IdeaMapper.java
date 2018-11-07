package Mappers;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import clasesJava.Idea;



public interface IdeaMapper {

	public List<Idea> consultarIdeas();
	
	public void insertarIdea(@Param("Idea") Idea idea);
	
	public Idea consultarIdea(@Param("idid")int id);

}
