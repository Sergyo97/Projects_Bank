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
import edu.eci.pdsw.samples.entities.Votado;
import edu.eci.pdsw.samples.services.ExcepcionBancoIniciativas;
import edu.eci.pdsw.samples.services.impl.BancoIniciativasImpl;

@ManagedBean(name = "IdeaBean")
@RequestScoped
@SessionScoped
@SuppressWarnings("deprecation")

public class IdeaBean extends BasePageBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{param.correo}, #{param.idIni}")


	private String correo;
	private boolean buscar=false;
	private String palabraClave;

	@Inject
	private BancoIniciativasImpl bancoini;


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
		if(!buscar) {
			try {
				return bancoini.consultarIdeas();
			}catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al consultar la idea", e);
			}
		}else {
			try {				
				return bancoini.consultarPalabrasClave(palabraClave);
			}catch (PersistenceException e) {
				throw new ExcepcionBancoIniciativas("Error al consultar la idea", e);
			}
		}
	};

	public void consultarIdea(String palabraClave) throws ExcepcionBancoIniciativas{
		this.palabraClave=palabraClave;
		buscar = true;
		getIdeasGeneral();		
	};
	
	
	public void registrarVoto(int id) throws ExcepcionBancoIniciativas{
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		try {
			if (votadoPorEstaIdea(id, (String)session.getAttribute("correo"))) {
				bancoini.quitarVoto(id,(String)session.getAttribute("correo"));
				bancoini.eliminarVoto(id,(String)session.getAttribute("correo"));
				
			}else {
				bancoini.ponerVoto(id,(String)session.getAttribute("correo"));
				bancoini.insertarVoto(id,(String)session.getAttribute("correo"));
			}
		} catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al registra voto", e);
		}
	}
	
	
	
	public List<Votado> consultarVotoIdea(int id) throws ExcepcionBancoIniciativas {
		try {
			return bancoini.consultarVotosIdea(id);
		} catch (PersistenceException e) {
			throw new ExcepcionBancoIniciativas("Error al consultar voto", e);
		}		
	}
	
	public boolean votadoPorEstaIdea(int id, String correo) throws ExcepcionBancoIniciativas {
		return bancoini.consultarVotoPorEstaIdea(id,correo);
	}

	public void insertarIdea(String titulo,int tipo, String descripcion) throws ExcepcionBancoIniciativas{
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int id = bancoini.consultarId();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		Date date1 = new Date(dateFormat.format(date));		
		TipoIdea tIdeaId= bancoini.consultarTipoIdea(tipo);
		Idea idea =new Idea(id, descripcion, "En espera", date1, 0, titulo, bancoini.consultarUsuario((String)session.getAttribute("correo")).getCorreo(), tIdeaId);
		try {
			bancoini.insertarIdea(idea);
		}catch (Exception e) {
			throw new ExcepcionBancoIniciativas("Error al insertar la idea", e);
		}
	}
	
	public void modificarIdea(int id, String descripcion) throws ExcepcionBancoIniciativas{
		bancoini.modificarDescripcion(id,descripcion);
	
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
