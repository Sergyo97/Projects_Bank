package edu.eci.pdsw.sampleprj.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.Usuario;

public interface UsuarioDAO {
	
	public Usuario consultarUsuario(int id) throws PersistenceException;
    
    public void insertarUsuario(Usuario usuario) throws PersistenceException;
    
    public List<Usuario> consultarUsuarios() throws PersistenceException;
    
    public List<Idea> consultarIdeasUsuario(int carne) throws PersistenceException;
    
}
