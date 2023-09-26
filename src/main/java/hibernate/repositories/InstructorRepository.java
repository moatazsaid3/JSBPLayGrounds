package hibernate.repositories;

import hibernate.Hibernate;
import hibernate.entities.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;


public class InstructorRepository extends Repository {
    @Override
    public Instructor getById(UUID id) {
        Transaction transaction = null;
        Instructor instructor = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            instructor = session.get(Instructor.class, id);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
        return instructor;
    }

    @Override
    public List getAll() {
        Transaction transaction = null;
        List<Instructor> instructors = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            instructors = session.createQuery("from Instructor", Instructor.class).list();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
        return instructors;
    }

    @Override
    public void deleteById(UUID id) {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, id);
            session.remove(instructor);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }

}
