package edu.eci.pdsw.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.pdsw.sampleprj.dao.IdeaDAO;
import edu.eci.pdsw.sampleprj.dao.TipoIdeaDAO;
import edu.eci.pdsw.sampleprj.dao.UsuarioDAO;
import edu.eci.pdsw.sampleprj.dao.VotoDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisIdeaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisTipoIdeaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisUsuarioDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisVotadoDAO;
import edu.eci.pdsw.samples.services.BancoIniciativas;
import edu.eci.pdsw.samples.services.impl.BancoIniciativasImpl;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                // TODO Add service class associated to Stub implementation
                bind(IdeaDAO.class).to(MyBatisIdeaDAO.class);               
                bind(TipoIdeaDAO.class).to(MyBatisTipoIdeaDAO.class);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(VotoDAO.class).to(MyBatisVotadoDAO.class);
                bind(BancoIniciativas.class).to(BancoIniciativasImpl.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}