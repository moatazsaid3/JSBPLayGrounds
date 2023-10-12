package hibernate.repositories;

import hibernate.Hibernate;
import hibernate.entities.Course;
import hibernate.entities.Instructor;
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
    public void getCourseNameAndStudents(){
        Transaction transaction = null;

        List<Instructor> instructors = null;// data that will be returned
        Course cours = getById(UUID.fromString("aca490ed-8c4a-4620-9977-7af1c12cbb57"));
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            List<Object[]> list = session.createQuery("select c.name, c.startDate, s.firstName || ' ' || s.lastName from Course c join c.students s").list();
            for (Object[] row : list) {
                System.out.println("Course: " + row[0] + ", Student name: " + row[1]);
            }
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }
    public void getCourseNameAndStudentsAdvanced(){
        Transaction transaction = null;

        List<Instructor> instructors = null;// data that will be returned
        Course cours = getById(UUID.fromString("aca490ed-8c4a-4620-9977-7af1c12cbb57"));
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            List<Object[]> list = session.createQuery("select c.name, s.firstName || ' ' || s.lastName from Course c left join c.students s where c.courseLevel = 'advanced'").list();
            for (Object[] row : list) {
                System.out.println("Course: " + row[0] + ", Student name: " + row[1]);
            }
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }
}
