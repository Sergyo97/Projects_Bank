package clasesJava;

import java.io.Serializable;

public class TipoIdea implements Serializable{
	int id;
	String tipo;
	
	public TipoIdea(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "TipoIdea [id=" + id + ", tipo=" + tipo + "]";
	}
	
	
	
	

}
