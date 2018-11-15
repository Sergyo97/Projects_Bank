package edu.eci.pdsw.samples.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.IdeaMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoIdeaMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoUsuarioMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.pdsw.samples.entities.Idea;
import edu.eci.pdsw.samples.entities.TipoIdea;

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
		TipoUsuarioMapper tum= sqlss.getMapper(TipoUsuarioMapper.class);
		
		
		//GENERAL
		//System.out.println(im.consultarId().getId()+1);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		
		// IDEAS 
		//System.out.println(im.consultarIdeas());
		//revisar porque tipo es null		
		//System.out.println(im.consultarIdea(1));	
		//System.out.println(im.consultarPalabrasClave("e"));	
		
		//im.actualizarEstado("el neoestado", 2);
		
		
		//Date date = new Date(2018, 11, 7);
		//TipoIdea ti= new TipoIdea(1, "Bienestar Universitario");
		
		//Idea idea1 = new Idea(2, "arreglar B0","En espera de respuesta" , ti , 30,  date, 2141060, "prueba 2");
		
		//im.insertarIdea(idea1);
		
		
		//TipoIdea
		//System.out.println(tim.consultarTipoIdeas());
		//System.out.println(tim.getTipoIdea(2));
		
		//TipoIdea ti= new TipoIdea( 8, "Economía");
		//tim.addTipoIdea(ti);
		
		//TipoUsuario
		//System.out.println(tum.consultarTiposUsuario());
		//System.out.println(tum.getTipoUsuario(4));
		
		//USUARIOS
		
		//Tipo usuario esta null
		//System.out.println(um.consultarUsuario(2141060));
		//System.out.println(um.ConsultarUsuarioPorCorreo("david.diaz-d@mail.escuelaing.edu.co"));
		
		
		
		sqlss.commit();
		sqlss.close(); 
	}

}