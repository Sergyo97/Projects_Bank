package edu.eci.pdsw.sampleprj.dao;

import javax.persistence.PersistenceException;

import edu.eci.pdsw.samples.entities.Usuario;

public interface UsuarioDAO {
	
	public Usuario consultarUsuario(int id) throws PersistenceException;
    
    public void insertarUsuario(Usuario usuario);
}
