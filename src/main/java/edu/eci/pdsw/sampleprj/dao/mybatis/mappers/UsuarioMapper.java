package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Usuario;

public interface UsuarioMapper {

		
		
	
	    public Usuario consultarUsuario(@Param("idus")int id); 
	    
	    
	   
	    
	    
	    public void insertarUsuario(@Param("Usuario") Usuario us);

	    
	    /**
	    
	    public List<Cliente> consultarClientes();
	    
	    public ItemRentado consultarItemRentado(@Param("id")int id);
	    public List<ItemRentado> consultarItemsRentados();
	    public List<ItemRentado> consultarItemsRentados(@Param("id")long id);
	    public long consultarMultaAlquiler(@Param("iitem")int iditem,@Param("fechaDevolucion") Date fechaDevolucion);
	    public void registrarAlquilerCliente(@Param("itemRentado")ItemRentado it);
	    public void vetarCliente(@Param("id") long docu,@Param("estado") boolean estado);
		*/
	}


