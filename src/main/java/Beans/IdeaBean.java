package Beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;

import clasesJava.TipoIdea;
import clasesJava.TipoUsuario;
import servicios.BancoIniciativas;

@SuppressWarnings("deprecation")
@ManagedBean(name = "IdeaBean")
@RequestScoped

public class IdeaBean extends BasePageBean{
	@ManagedProperty(value="#{param.id}")
	private int id;	
	private long valor=0;

	@Inject
	private BancoIniciativas bancoini;

	//Usuario Bean o IdeaBean
	public void agregarPropuestaUsuario(int id,String nombre_iniciativa,String estado,	TipoIdea t_idea_id,int votos,Date fecha_creacion,TipoUsuario usuario_carne) throws Exception{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();		
		try {				
			bancoini.agregarPropuestaUsuario(id, nombre_iniciativa, estado, t_idea_id, votos, fecha_creacion, usuario_carne);  
		} catch (Exception e) {
			throw e;
		}
	};


}
