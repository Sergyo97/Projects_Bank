package edu.eci.pdsw.samples.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.IdeaMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoIdeaMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.UsuarioMapper;

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
		
		//System.out.println(im.consultarIdeas());
		//System.out.println(um.consultarUsuarios());
		System.out.println(tim.consultarTipoIdeas());
		
		
		sqlss.commit();
		sqlss.close(); 
	}

}