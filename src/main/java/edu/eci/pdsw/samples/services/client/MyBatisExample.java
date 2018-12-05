package edu.eci.pdsw.samples.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.IdeaMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoIdeaMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.VotadoMapper;
import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.TipoIdea;
import edu.eci.pdsw.samples.entities.TipoUsuario;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.entities.Votado;

public class MyBatisExample {

	/**
	 * Método que construye una fábrica de sesiones de MyBatis a partir del
	 * archivo de configuración ubicado en src/main/resources
	 *
	 * @return instancia de SQLSessionFactory
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		if (sqlSessionFactory == null) {
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e.getCause());
			}
		}
		return sqlSessionFactory;
	}

	/**
	 * Programa principal de ejempo de uso de MyBATIS
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String args[]) throws SQLException {
		
		SqlSessionFactory sessionfact = getSqlSessionFactory();
		SqlSession sqlss = sessionfact.openSession();

		IdeaMapper im= sqlss.getMapper(IdeaMapper.class);
		UsuarioMapper um = sqlss.getMapper(UsuarioMapper.class);
		TipoIdeaMapper tim = sqlss.getMapper(TipoIdeaMapper.class);
		VotadoMapper vm = sqlss.getMapper(VotadoMapper.class);
		
		
		//GENERAL
		//System.out.println(im.consultarId().getId()+1);
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//Date date = new Date();
		//System.out.println(dateFormat.format(date));
		
		
		// IDEAS 
		//System.out.println(im.consultarIdeas());
		//System.out.println(im.consultarIdea(1));	
		//System.out.println(im.consultarPalabrasClave(""));	
		//im.actualizarEstado("En espera", 2);
		
		//im.actualizarVoto(1);
		
		
		//Date date = new Date(2018, 11, 7);
		//TipoIdea ti= new TipoIdea(1, "BIENESTAR UNIVERSITARIO");
		//Idea idea1 = new Idea(6,"Esto es una prueba","En espera",date,0,"Prueba","sergio.ruiz@mail.escuelaing.edu.co",ti);
		
		//im.insertarIdea(idea1);
		
		
		//TipoIdea
		//System.out.println(tim.consultarTipoIdeas());
		//System.out.println(tim.getTipoIdea(2));
		//TipoIdea ti= new TipoIdea( 8, "Economía");
		//tim.addTipoIdea(ti);
		
		
		//USUARIOS
		//System.out.println(um.consultarUsuario("sergio.ruiz@mail.escuelaing.edu.co"));
		//System.out.println(um.consultarLogin("italo.cufino@mail.escuelaing.edu.co", "12345"));
		
		
		//VOTADO
		/*Idea idea=im.consultarIdea(2);
		Usuario usuario = um.consultarUsuario("sergio.ruiz@mail.escuelaing.edu.co");
		//Votado voto = new Votado(idea, usuario, date);
		vm.insertarVoto(usuario.getCorreo(),idea.getId());
		System.out.println(vm.consultarVotosIdea(1).size());
		for(int i=0;i<vm.consultarVotosIdea(1).size();i++) {
			System.out.println(vm.consultarVotosIdea(1).get(i).getCorreoUsuario()+", "+vm.consultarVotosIdea(1).get(i).getIdeas().getTitulo()+", "+vm.consultarVotosIdea(1).get(i).getFecha());
		}*/
		
		//System.out.println(vm.consultarVotoPorEstaIdea(20,"david.diaz@mail.escuelaing.edu.co"));
		
		im.modificarDescripcion(2,"Holo");
		
		sqlss.commit();
		sqlss.close(); 
	}

}