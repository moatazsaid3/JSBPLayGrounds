package hibernate.repositories;

import hibernate.Hibernate;
import hibernate.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class StudentRepository extends Repository {


    @Override
    public Student getById(UUID id) {
        Transaction transaction = null;
        Student student = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            student = session.get(Student.class, id);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
        return student;
    }
    @Override
    public List getAll() {
        Transaction transaction = null;
        List<Student> students = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            students = session.createQuery("from Student", Student.class).list();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
        return students;
    }
    @Override
    public void deleteById(UUID id) {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.remove(student);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }
}
