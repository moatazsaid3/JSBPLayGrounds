package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import hibernate.entities.*;



public class Hibernate{

    private static SessionFactory factory;


    public static SessionFactory getFactory() {
        if(factory == null) {

            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Instructor.class).addAnnotatedClass(Student.class).addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetails.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            factory = configuration.buildSessionFactory(serviceRegistry);
        }

        return factory;
    }

}
