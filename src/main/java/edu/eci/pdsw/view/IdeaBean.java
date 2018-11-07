package edu.eci.pdsw.view;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.TipoIdea;
import edu.eci.pdsw.samples.services.impl.BancoIniciativasImpl;

@SuppressWarnings("deprecation")
@ManagedBean(name = "IdeaBean")
@RequestScoped

public class IdeaBean extends BasePageBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{param.id}")
	private int id;	
	private Idea idea;
	
	@Inject
	private BancoIniciativasImpl bancoini;

	
	public Idea consultarIdeas(int id) throws Exception{
		try {
			return bancoini.consultarIdea(id);
		}catch (Exception e) {
			throw e;
		}

	};
	
	
	public List<Idea> consultarIdeas() throws Exception{
		try {
			return bancoini.consultarIdeas();
		}catch (Exception e) {
			throw e;
		}

	};
	public void insertarIdea(int id,String nombreIniciativa, String estado, TipoIdea tIdeaId,int votos,Date fechaCreacion,int usuarioCarne) throws Exception{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		idea = new Idea(id, nombreIniciativa, estado, tIdeaId, votos, fechaCreacion, usuarioCarne);
		try {				
			bancoini.insertarIdea(idea);
		} catch (Exception e) {
			throw e;
		}		
	};



}
