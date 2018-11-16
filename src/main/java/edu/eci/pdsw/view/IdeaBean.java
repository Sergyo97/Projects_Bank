package edu.eci.pdsw.view;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.TipoIdea;
import edu.eci.pdsw.samples.services.ExcepcionBancoIniciativas;
import edu.eci.pdsw.samples.services.impl.BancoIniciativasImpl;

@ManagedBean(name = "IdeaBean")
@RequestScoped
@SuppressWarnings("deprecation")

public class IdeaBean extends BasePageBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{param.correo}")
	
	private String correo;	
	private Idea idea;

	@Inject
	private BancoIniciativasImpl bancoini;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public List<Idea> getIdeas() throws ExcepcionBancoIniciativas{
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		try {
			return bancoini.consultarIdeasUsuario((String)session.getAttribute("correo"));
		}catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al consultar la idea", e);
		}
	};

	public List<Idea> getIdeasGeneral() throws ExcepcionBancoIniciativas{
		try {
			return bancoini.consultarIdeas();
		}catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al consultar la idea", e);
		}
	};
	
	public void insertarIdea(String titulo,int tipo, String descripcion) throws ExcepcionBancoIniciativas{
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int id = bancoini.consultarId();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		Date date1 = new Date(dateFormat.format(date));		
		TipoIdea tIdeaId= bancoini.consultarTipoIdea(tipo);
		//System.out.println("ID: "+id+" nombreIniciativa: "+nombreIniciativa+" fechaCreacion: "+date1+" descripcion "+descripcion +" usuarioCarne: " +usuarioCarne);
		idea =new Idea(id, descripcion, "En espera", date1, 0, titulo, bancoini.consultarUsuario((String)session.getAttribute("correo")).getCorreo(), tIdeaId);
		try {
			bancoini.insertarIdea(idea);
		}catch (Exception e) {
			throw new ExcepcionBancoIniciativas("Error al insertar la idea", e);
		}
	}
}
