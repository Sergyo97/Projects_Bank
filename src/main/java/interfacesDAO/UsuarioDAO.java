package interfacesDAO;

import java.util.Date;

import javax.persistence.PersistenceException;

import clasesJava.TipoIdea;
import clasesJava.TipoUsuario;
import clasesJava.Usuario;

public interface UsuarioDAO {
	
	public Usuario consultarUsuario(int id) throws PersistenceException;
    
    public void insertarUsuario(Usuario usuario);
}
