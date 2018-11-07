package Beans;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;

import clasesJava.Idea;
import clasesJava.TipoIdea;
import clasesJava.TipoUsuario;
import clasesJava.Usuario;

import servicios.BancoIniciativasImpl;

@SuppressWarnings("deprecation")
@ManagedBean(name = "usuarioBean")
@RequestScoped

public class UsuarioBean extends BasePageBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{param.usuario}")
	private String usuario;
	private Usuario us;
	private long valor=0;
	private long l;

	//ACCION DUDOSA
	@Inject
	private BancoIniciativasImpl bancoini;

	public Usuario consultarUsuario(int id) throws Exception{
		try {
			return bancoini.consultarUsuario(id);
		} catch (Exception e) {
			throw e;
		}
	};

	
	public void insertarUsuario(String nombre, String correo, long carne, TipoUsuario tipoId, boolean activo, ArrayList<Idea> ideasDeUsuario) throws Exception {
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		us = new Usuario(nombre, correo, carne, tipoId, activo, ideasDeUsuario);
		try {
			bancoini.insertarUsuario(us);
		} catch (Exception e) {
			throw e;
		}
	};

}
