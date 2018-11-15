package edu.eci.pdsw.view;


import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionBancoIniciativas;
import edu.eci.pdsw.samples.services.impl.BancoIniciativasImpl;

@ManagedBean(name = "usuarioBean")
@ApplicationScoped

public class UsuarioBean extends BasePageBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@ManagedProperty(value = "#{param.usuario}")
//	private String usuario;
//	private Usuario us;

	//ACCION DUDOSA
	@Inject
	private BancoIniciativasImpl bancoini;
	
	public List<Usuario> getUsuarios() throws ExcepcionBancoIniciativas{
		try {
			return bancoini.consultarUsuarios();
		} catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al consultar los usuarios", e);
		}
	};

	public Usuario consultarUsuario(int id) throws ExcepcionBancoIniciativas{
		try {
			return bancoini.consultarUsuario(id);
		} catch (PersistenceException e) {
			throw e;
		}
	};
	
	public Usuario getUsuarioPorCorreo() throws ExcepcionBancoIniciativas{
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session  = (HttpSession) fc.getExternalContext().getSession(true); 
		try {
			
			return bancoini.ConsultarUsuarioPorCorreo((String)session.getAttribute("correo"));
		} catch (PersistenceException e) {
			throw e;
		}
	};

	

}
