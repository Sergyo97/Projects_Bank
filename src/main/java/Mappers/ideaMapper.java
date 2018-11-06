package Mappers;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import clasesJava.Idea;



public interface ideaMapper {


	public List<Idea> consultarIdeas(@Param("idid")int id);
	public void insertarIdea(@Param("Idea") Idea idea);


}
