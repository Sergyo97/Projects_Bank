package edu.eci.pdsw.sampleprj.dao;

import java.util.List;

import edu.eci.pdsw.samples.entities.TipoIdea;

public interface TipoIdeaDAO {

	public List<TipoIdea> consultarTipoIdeas();
    
    public TipoIdea getTipoIdea(int id);
    
    public void addTipoIdea(TipoIdea ti);
	
}
