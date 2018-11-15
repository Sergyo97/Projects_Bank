package edu.eci.pdsw.view;


import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionBancoIniciativas;
import edu.eci.pdsw.samples.services.impl.BancoIniciativasImpl;

@ManagedBean(name = "loginBean")
@SessionScoped

public class LoginBean extends BasePageBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String correo;
	private int carne;

	
	@Inject
	private BancoIniciativasImpl bancoini;
		
	public void validarUsuario() throws ExcepcionBancoIniciativas,IOException{
		FacesContext fc = FacesContext.getCurrentInstance();
		Usuario user = bancoini.ConsultarUsuarioPorCorreo(correo);
		if(user != null) {
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
			session.setAttribute("correo",correo);
			session.setAttribute("carne", carne);
			fc.getExternalContext().redirect("/faces/usuarios.xhtml");
		}else {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al encontrar el usuario","Error"));
		}
	}


	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	};
	
	
	

}
