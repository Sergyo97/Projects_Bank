package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.TipoIdeaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoIdeaMapper;
import edu.eci.pdsw.samples.entities.TipoIdea;

public class MyBatisTipoIdeaDAO implements TipoIdeaDAO {
	
	
	@Inject
	private TipoIdeaMapper tipoIdeaMapper;

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
