package clasesJava;

import java.io.Serializable;

public class TipoUsuario implements Serializable {
	int id;
	String descripcion;
	public TipoUsuario(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "tipoUsuario [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	

}
