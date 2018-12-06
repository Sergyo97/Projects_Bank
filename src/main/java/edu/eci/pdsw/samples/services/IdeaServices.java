package edu.eci.pdsw.samples.services;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "ideaService")
@ApplicationScoped
public class IdeaServices {     

	private final static String[] tipos;

	static {                
		tipos = new String[10];
		tipos[0] = "BIENESTAR UNIVERSITARIO";
		tipos[1] = "DECANATURA SISTEMAS";
		tipos[2] = "DECANATURA CIVIL";
		tipos[3] = "DECANATURA INDUSTRIAL";
		tipos[4] = "DECANATURA AMBIENTAL";
		tipos[5] = "DECANATURA MECANICA";
		tipos[6] = "DECANATURA ELÉCTRICA";
		tipos[7] = "ECONOMÍA";
		tipos[8] = "ADMINISTRACIÓN";
		tipos[9] = "MATEMÁTICAS";
		tipos[9] = "OFICINA DE PROYECTOS (PMO)"; 
		tipos[9] = "DECANATURA ELECTRÓNICA"; }

	public List<String> getTipos() {
		return Arrays.asList(tipos);
	}
}