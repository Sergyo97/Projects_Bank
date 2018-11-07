package edu.eci.pdsw.samples.services;

import static com.google.inject.Guice.createInjector;

import java.util.Optional;

import org.mybatis.guice.XMLMyBatisModule;

import com.google.inject.Injector;

import edu.eci.pdsw.sampleprj.dao.IdeaDAO;
import edu.eci.pdsw.sampleprj.dao.TipoIdeaDAO;
import edu.eci.pdsw.sampleprj.dao.TipoUsuarioDAO;
import edu.eci.pdsw.sampleprj.dao.UsuarioDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisIdeaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisTipoIdeaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisTipoUsuarioDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisUsuarioDAO;
import edu.eci.pdsw.samples.services.impl.BancoIniciativasImpl;

public class BancoIniciativasFactory {

	private static BancoIniciativasFactory instance = new BancoIniciativasFactory();

	private static Optional<Injector> optInjector;

	private Injector myBatisInjector(String env, String pathResource) {
		return createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				setEnvironmentId(env);
				setClassPathResource(pathResource);
				bind(IdeaDAO.class).to(MyBatisIdeaDAO.class);
				bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
				bind(TipoIdeaDAO.class).to(MyBatisTipoIdeaDAO.class);
				bind(TipoUsuarioDAO.class).to(MyBatisTipoUsuarioDAO.class);
				bind(BancoIniciativas.class).to(BancoIniciativasImpl.class);
				
			}
		});
	}

	private BancoIniciativasFactory(){
		optInjector = Optional.empty();
	}

	public BancoIniciativas getBancoIniciativas(){
		if (!optInjector.isPresent()) {
			optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
		}

		return optInjector.get().getInstance(BancoIniciativas.class);
	}


	public BancoIniciativas getServiciosAlquilerTesting(){
		if (!optInjector.isPresent()) {
			optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
		}

		return optInjector.get().getInstance(BancoIniciativas.class);
	}


	public static BancoIniciativasFactory getInstance(){
		return instance;
	}

}