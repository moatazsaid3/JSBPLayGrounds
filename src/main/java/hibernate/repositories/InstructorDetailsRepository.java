package hibernate.repositories;

import hibernate.entities.Instructor;
import hibernate.entities.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class InstructorDetailsRepository extends Repository {
    @Override
    public InstructorDetails getById(UUID id) {
        Transaction transaction = null;
        InstructorDetails details = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            details = session.get(InstructorDetails.class, id);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
        return details;
    }

    @Override
    public List getAll() {
        Transaction transaction = null;
        List<InstructorDetails> details = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            details = session.createQuery("from InstructorDetails ", InstructorDetails.class).list();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
        return details;
    }

    @Override
    public void deleteById(UUID id) {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            InstructorDetails details = session.get(InstructorDetails.class, id);
            session.remove(details);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }
}
