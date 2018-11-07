package edu.eci.pdsw.sampleprj.dao;

import java.util.List;

import edu.eci.pdsw.samples.entities.TipoUsuario;

public interface TipoUsuarioDAO {

	public List<TipoUsuario> consultarTiposUsuario();

	public TipoUsuario getTipoUsuario(int id);
}
