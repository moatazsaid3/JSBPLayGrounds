package hibernate.repositories;

import hibernate.Hibernate;
import hibernate.entities.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class CourseRepository extends Repository {
    @Override
    public Course getById(UUID id) {
        Transaction transaction = null;
        Course course = null;
        try(Session session = this.factory.openSession()) {
            transaction = session.beginTransaction();
            course = session.get(Course.class, id);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
        return course;
    }

    @Override
    public List getAll() {
        Transaction transaction = null;
        List<Course> courses = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            courses = session.createQuery("from Instructor", Course.class).list();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
        return courses;
    }
    @Override
    public void deleteById(UUID id) {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, id);
            session.remove(course);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }
}
