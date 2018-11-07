package clasesJava;

import java.io.Serializable;
import java.util.Date;

public class Idea implements Serializable{
	
	int id;
	String nombre_iniciativa;
	String estado;
	TipoIdea t_idea_id;
	int votos;
	Date fecha_creacion;
	int usuario_carne;
	
	public Idea(int id, String nombre_iniciativa, String estado, TipoIdea t_idea_id, int votos, Date fecha_creacion, int usuario_carne) {
		this.id = id;
		this.nombre_iniciativa = nombre_iniciativa;
		this.estado = estado;
		this.t_idea_id = t_idea_id;
		this.votos = votos;
		this.fecha_creacion = fecha_creacion;
		this.usuario_carne = usuario_carne;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_iniciativa() {
		return nombre_iniciativa;
	}

	public void setNombre_iniciativa(String nombre_iniciativa) {
		this.nombre_iniciativa = nombre_iniciativa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public TipoIdea getT_idea_id() {
		return t_idea_id;
	}

	public void setT_idea_id(TipoIdea t_idea_id) {
		this.t_idea_id = t_idea_id;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public int getUsuario_carne() {
		return usuario_carne;
	}

	public void setUsuario_carne(int usuario_carne) {
		this.usuario_carne = usuario_carne;
	}

	@Override
	public String toString() {
		return "Idea [id=" + id + ", nombre_iniciativa=" + nombre_iniciativa + ", estado=" + estado + ", t_idea_id="
				+ t_idea_id + ", votos=" + votos + ", fecha_creacion=" + fecha_creacion + ", usuario_carne="
				+ usuario_carne + "]";
	}
	
	
	

	
	

	
	

}
