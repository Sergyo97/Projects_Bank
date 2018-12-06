package edu.eci.pdsw.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.services.ExcepcionBancoIniciativas;
import edu.eci.pdsw.samples.services.IdeaServices;
import edu.eci.pdsw.samples.services.impl.BancoIniciativasImpl;

@ManagedBean(name="ideasTableStateView")
@SessionScoped
public class IdeasStateView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Idea> ideas;
	private List<Idea> filteredIdeas;

	@Inject
	private BancoIniciativasImpl bancoini;	

	@ManagedProperty("#{ideaService}")
	private IdeaServices service;

	

	@PostConstruct
	public void init() throws ExcepcionBancoIniciativas {		
		ideas = bancoini.consultarIdeas();		
	}

	public List<String> getTipos() {
		return service.getTipos();
	}	

	public List<Idea> getIdeas() {
		return ideas;
	}	

	public List<Idea> getFilteredIdeas() {
		return filteredIdeas;
	}

	public void setFilteredIdeas(List<Idea> filteredIdeas) {
		this.filteredIdeas = filteredIdeas;
	}

	public void setService(IdeaServices service) {
		this.service = service;
	}

}