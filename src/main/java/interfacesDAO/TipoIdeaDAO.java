package interfacesDAO;

import java.util.List;



import clasesJava.TipoIdea;

public interface TipoIdeaDAO {

	public List<TipoIdea> consultarTipoIdeas();
    
    public TipoIdea getTipoIdea(int id);
    
    public void addTipoItem(TipoIdea ti);
	
}
