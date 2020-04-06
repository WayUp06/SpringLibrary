package main;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



@org.springframework.context.annotation.Configuration
@Component
public class HibernateUtil {

    @Bean
    public static SessionFactory getSession() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Entity.Author.class);
        configuration.addAnnotatedClass(Entity.Book.class);
        configuration.addAnnotatedClass(Entity.BookExample.class);
        configuration.addAnnotatedClass(Entity.Usage.class);
        configuration.addAnnotatedClass(Entity.User.class);
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory mySessionalFactory = configuration.buildSessionFactory(serviceRegistry);
        return mySessionalFactory;
    }


}
