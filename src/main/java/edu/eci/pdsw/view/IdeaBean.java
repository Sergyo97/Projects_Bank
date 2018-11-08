package edu.eci.pdsw.view;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.TipoIdea;
import edu.eci.pdsw.samples.services.ExcepcionBancoIniciativas;
import edu.eci.pdsw.samples.services.impl.BancoIniciativasImpl;

@SuppressWarnings("deprecation")
@ManagedBean(name = "IdeaBean")
@RequestScoped

public class IdeaBean extends BasePageBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{param.users}")
	
	private int users;		
	
	public int getUsuarioCarne() {
		return users;
	}

	public void setUsuarioCarne(int users) {
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
}
