package guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

import clasesDao.MyBatisIdeaDAO;
import clasesDao.MyBatisTipoIdeaDAO;
import clasesDao.MyBatisTipoUsuarioDAO;
import clasesDao.MyBatisUsuarioDAO;
import interfacesDAO.IdeaDAO;
import interfacesDAO.TipoIdeaDAO;
import interfacesDAO.TipoUsuarioDAO;
import interfacesDAO.UsuarioDAO;

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
                bind(TipoUsuarioDAO.class).to(MyBatisTipoUsuarioDAO.class);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                //bind(ServiciosAlquiler.class).to(ServiciosAlquilerImpl.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}