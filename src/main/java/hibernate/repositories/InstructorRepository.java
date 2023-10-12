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
            System.out.println(instructor.toString());
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

    public void testLAZY(Instructor ins){
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            System.out.println(ins.toString());
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }
    public void getInstructorNameAndCourseName(){
        Transaction transaction = null;


        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            String HQL0 = "select i.firstName, c.name from Instructor i join i.courses c";

//            select cat.id, (select max(kit.weight) from cat.kitten kit)
//            from Cat as cat

            String HQL1 = "select i.firstName, (select i.firstName || ' ' || i.lastName,  courses.name from i.courses courses where courses.instructor.id = :id) from Instructor i ";
            List<Object[]> list = session.createQuery(HQL1).setParameter("id", UUID.fromString("aca490ed-8c4a-4620-9977-7af1c12cbb57")).list();

            for (Object[] row : list) {
                System.out.println("Instructor: " + row[0] + ", Course: " + row[1]);
            }
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }
    public void getInstructorNameAndYoutubeChannel(){
        Transaction transaction = null;

        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            List<Object[]> list = session.createQuery("select i.firstName, iDetails.youtubeChannel from Instructor i join i.details iDetails").list();
            for (Object[] row : list) {
                System.out.println("Instructor: " + row[0] + ",  Youtube channel: " + row[1]);
            }
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }
    public void getInstructorNameAndStudentsCourseID(){
        Transaction transaction = null;

        List<Instructor> instructors = null;// data that will be returned
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            List<Object[]> list = session.createQuery("select i.firstName || ' ' || i.lastName as instructorName, s.firstName || ' ' || s.lastName , c.id as studentName from  Instructor i left join i.courses c join c.students as s ").list();
            for (Object[] row : list) {
                System.out.println("Instructor: " + row[0] + ", Student : " + row[1]+", course id : " + row[2]);
            }
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }
}
