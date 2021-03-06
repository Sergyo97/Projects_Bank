package edu.eci.pdsw.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;
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
	private int tipo;	
	private String estado;
	private List<Idea> filteredIdeas;
	private int id;
	
	private final static String[] tiposIdeas;

	static {                
		tiposIdeas = new String[12];
		tiposIdeas[0] = "BIENESTAR UNIVERSITARIO";
		tiposIdeas[1] = "DECANATURA SISTEMAS";
		tiposIdeas[2] = "DECANATURA CIVIL";
		tiposIdeas[3] = "DECANATURA INDUSTRIAL";
		tiposIdeas[4] = "DECANATURA AMBIENTAL";
		tiposIdeas[5] = "DECANATURA MECANICA";
		tiposIdeas[6] = "DECANATURA ELÉCTRICA";
		tiposIdeas[7] = "ECONOMÍA";
		tiposIdeas[8] = "ADMINISTRACIÓN";
		tiposIdeas[9] = "MATEMÁTICAS";
		tiposIdeas[10] = "OFICINA DE PROYECTOS (PMO)"; 
		tiposIdeas[11] = "DECANATURA ELECTRÓNICA"; }

	public List<String> getTiposIdeas() {
		return Arrays.asList(tiposIdeas);
	}
		
	@Inject
	private BancoIniciativasImpl bancoini;

	FacesContext fc = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

	public List<Idea> getIdeas() throws ExcepcionBancoIniciativas{
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
		try {
			System.out.println(id);
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

	public void insertarIdea(String titulo, String descripcion) throws ExcepcionBancoIniciativas{
		
		try {
			boolean esta=false;
			for (Idea i:bancoini.consultarIdeas()) {			
				if(i.getTitulo().equals(titulo) || i.getTitulo().equals(descripcion) || i.getDescripcion().equals(titulo) || i.getDescripcion().equals(descripcion)) {
					esta=true;
					break;
				} 
			}		
			
			if(titulo != "" && descripcion != "" && esta==false && tipo!=0) {
				int id = bancoini.consultarId();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				Date date1 = new Date(dateFormat.format(date));		
				TipoIdea tIdeaId= bancoini.consultarTipoIdea(tipo);
				Idea idea =new Idea(id, descripcion, "En espera de revisión", date1, 0, titulo, bancoini.consultarUsuario((String)session.getAttribute("correo")).getCorreo(), tIdeaId);
				bancoini.insertarIdea(idea);
			}				
		}catch (Exception e) {
			throw new ExcepcionBancoIniciativas("Error al insertar la idea", e);
		}
	}
		
	public void modificarIdea(int id, String descripcion) throws ExcepcionBancoIniciativas{
		boolean esta=false;
		
		for (Idea i:bancoini.consultarIdeas()) {			
			if( i.getTitulo().equals(descripcion) || i.getDescripcion().equals(descripcion)) {
				esta=true;
				break;
			} 
		}
		
		if( descripcion != "" && esta==false ) {
			bancoini.modificarDescripcion(id,descripcion);
		}
	
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void actualizarEstadoIdea(int id) throws ExcepcionBancoIniciativas {
		if (bancoini.consultarIdea(id).getEstado()!="Solucionado") {
			if (bancoini.consultarIdea(id).getEstado().equals("En espera de revisión")) {
				bancoini.actualizarEstado("En revisión", id);
			}
			else if (bancoini.consultarIdea(id).getEstado().equals("En revisión")) {
				bancoini.actualizarEstado("Proyecto", id);
			}else if (bancoini.consultarIdea(id).getEstado().equals("Proyecto")) {
				bancoini.actualizarEstado("Solucionado", id);
			}
		}
		
	}

	public String getCorreo() throws ExcepcionBancoIniciativas {
		return bancoini.consultarUsuario((String)session.getAttribute("correo")).getNombre();
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		System.out.println(estado);
		this.estado = estado;
	}
	
	public void setFilteredIdeas(List<Idea> filteredIdeas) {
		this.filteredIdeas = filteredIdeas;
	}

	public List<Idea> getFilteredIdeas() {
		return filteredIdeas;
	}

	
}
