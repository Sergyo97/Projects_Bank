package clasesDao;

import java.util.List;

import com.google.inject.Inject;

import Mappers.TipoIdeaMappers;
import clasesJava.TipoIdea;
import interfacesDAO.TipoIdeaDAO;

public class MyBatisTipoIdeaDAO implements TipoIdeaDAO {
	
	
	@Inject
	private TipoIdeaMappers tipoIdeaMapper;

	@Override
	public List<TipoIdea> consultarTipoIdeas() {
		return tipoIdeaMapper.consultarTipoIdeas();
	}

	@Override
	public TipoIdea getTipoIdea(int id) {
		return tipoIdeaMapper.getTipoIdea(id);
	}

	@Override
	public void addTipoIdea(TipoIdea ti) {
		tipoIdeaMapper.addTipoIdea(ti);

	}

}
