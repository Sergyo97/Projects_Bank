package edu.eci.pdsw.view;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.TipoUsuario;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.impl.BancoIniciativasImpl;

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
