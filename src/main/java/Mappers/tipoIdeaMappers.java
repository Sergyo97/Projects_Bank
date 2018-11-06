package Mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import clasesJava.TipoIdea;
import clasesJava.TipoUsuario;

public interface tipoIdeaMappers {
	
	public List<TipoIdea> consultarTipoIdeas();
    
    public TipoIdea getTipoIdea(@Param("id")int id);
    
    public void addTipoItem(@Param("ti")TipoIdea ti);
    
    public void agregarPropuestaUsuario(@Param("idus")int id, 
    		@Param("nombre_iniciativa")String nombre_iniciativa, 
    		@Param("estado")String estado,
    		@Param("t_idea_id")TipoIdea t_idea_id,
    		@Param("votos")int votos,
    		@Param("fecha_creacion")Date fecha_creacion,
    		@Param("usuario_carne")TipoUsuario usuario_carne);

}
