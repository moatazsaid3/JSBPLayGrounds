package hibernate.DAO;

import hibernate.Hibernate;
import hibernate.models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class CourseDAO implements DAO{
    private SessionFactory factory = Hibernate.getFactory();
    @Override
    public void save(Object course) {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }

    }

    @Override
    public Course getById(UUID id) {
        Transaction transaction = null;
        Course course = null;
        try(Session session = factory.openSession()) {
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
    public void update(Object instructor) {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(instructor);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
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
