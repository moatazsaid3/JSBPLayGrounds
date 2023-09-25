package hibernate;

import java.util.List;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import hibernate.models.*;



public class Hibernate{

    private static SessionFactory factory;


    public static SessionFactory getFactory() {
        if(factory == null) {

            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Instructor.class).addAnnotatedClass(Student.class).addAnnotatedClass(Course.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            factory = configuration.buildSessionFactory(serviceRegistry);
        }

        return factory;
    }

}
