package edu.eci.pdsw.view;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionBancoIniciativas;
import edu.eci.pdsw.samples.services.impl.BancoIniciativasImpl;

@ManagedBean(name = "usuarioBean")
@SessionScoped

public class UsuarioBean extends BasePageBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private BancoIniciativasImpl bancoini;
	
	public List<Usuario> getUsuarios() throws ExcepcionBancoIniciativas{
		try {
			return bancoini.consultarUsuarios();
		} catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al consultar los usuarios", e);
		}
	};

	public Usuario getconsultarUsuario() throws ExcepcionBancoIniciativas{
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session  = (HttpSession) fc.getExternalContext().getSession(true); 
		try {
			Usuario us=  bancoini.consultarLogin((String)session.getAttribute("correo"), (String)session.getAttribute("contra"));
			return us;
			
		} catch (PersistenceException e) {
			throw e;
		}
	};

}
