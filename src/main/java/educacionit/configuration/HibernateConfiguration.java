package educacionit.configuration;

import educacionit.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
    public SessionFactory configure() {
        Configuration configuracion = new Configuration();
        
        configuracion.setProperty("hibernate.connection.url",
                "jdbc:mysql://127.0.0.1:3306/eventos");
        configuracion.setProperty("hibernate.connection.user","root");
        configuracion.setProperty("hibernate.connection.password", "");
        configuracion.setProperty("hibernate.connection.driver_class", 
                                "com.mysql.jdbc.Driver");
        configuracion.setProperty("hibernate.dialect", 
                                "org.hibernate.dialect.MySQL5Dialect");
        configuracion.setProperty("hibernate.hbm2ddl.auto","update");
        configuracion.setProperty("hibernate.show_sql", "true");
       
        configuracion.addAnnotatedClass(Usuario.class);
        configuracion.addAnnotatedClass(Persona.class);
        configuracion.addAnnotatedClass(Cliente.class);
        configuracion.addAnnotatedClass(Empleado.class);
        
        // configuracion.addPackage("")
        
        StandardServiceRegistryBuilder rb = 
                new StandardServiceRegistryBuilder().applySettings(configuracion.getProperties());
        SessionFactory factory = configuracion.buildSessionFactory(rb.build());
        
        return factory;
    }
}
