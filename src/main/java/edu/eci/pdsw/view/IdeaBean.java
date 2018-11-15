package edu.eci.pdsw.view;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
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
	
	@ManagedProperty(value="#{param.users}")
	
	private int users;	
	
	private Idea idea;
	
	public int getUsers() {
		return users;
	}


	public void setUsers(int users) {
		this.users = users;
	}


	@Inject
	private BancoIniciativasImpl bancoini;

	
	public List<Idea> getIdeas() throws ExcepcionBancoIniciativas{
		try {
			return bancoini.consultarIdeasUsuario(users);
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
	
	public void insertarIdea(String nombreIniciativa,int tipo,String descripcion) throws ExcepcionBancoIniciativas{
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int id = bancoini.consultarid();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		Date date1 = new Date(dateFormat.format(date));		
		TipoIdea tIdeaId= bancoini.consultarTipoIdea(tipo);
		int usuarioCarne = 2138850;
		System.out.println("ID: "+id+" nombreIniciativa: "+nombreIniciativa+" fechaCreacion: "+date1+" descripcion "+descripcion +" usuarioCarne: " +usuarioCarne);
		idea =new Idea(id, nombreIniciativa, "En Espera", tIdeaId, 0,date1 , usuarioCarne, descripcion);
		try {
			bancoini.insertarIdea(idea);
		}catch (Exception e) {
			throw new ExcepcionBancoIniciativas("Error al insertar la idea", e);
		}
	}
}
