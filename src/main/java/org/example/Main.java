package org.example;


import hibernate.DAO.CourseDAO;
import hibernate.DAO.InstructorDAO;
import hibernate.DAO.StudentDAO;
import hibernate.Hibernate;
import hibernate.models.Course;
import hibernate.models.Instructor;
import jakarta.persistence.*;
import jakarta.persistence.metamodel.Metamodel;
import org.hibernate.*;
import org.hibernate.Cache;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.graph.RootGraph;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.relational.SchemaManager;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.stat.Statistics;



import javax.naming.ConfigurationException;
import javax.naming.NamingException;
import javax.naming.Reference;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        try{

            // ---- testing Instructor ----//
//            InstructorRepo InstructorRepo = new InstructorRepo() ; // postgres.DAL for instructor
//            InstructorRepo.createInstructor(
//                    "hema",
//                    "emad",
//                    "emad@dasd.com",
//                    "012354"); // create instructor with all fields
//            ArrayList<Instructor> instructors = InstructorRepo.getAllInstructors(); // get all instructors
//            Instructor instructor = InstructorRepo.getInstructorByID(52);
//            InstructorRepo.deleteInstructorByID(55);   // delete instructor by id
//            InstructorRepo.getNameAndCourses(1); // get the name of the instructor by id and the courses they teach
//            InstructorRepo.getNameAndCoursesAndStudents(1); //  get the name of the instructor by id and the courses they teach with the student enrolled in them



            // ---- testing Student ----//
//            StudentRepo studentRepo = new StudentRepo(); // postgres.DAL for student
//            studentRepo.createStudent(
//                    "student1",
//                    "awee",
//                    23,
//                    Student.Gender.Male,
//                    "student@school.com",
//                    "123123",
//                    1231231123); // create student with all fields
//            ArrayList<Student> students = studentRepo.getAllStudents(); // get all students
//            Student student = studentRepo.getStudentByID("28019f8d-3377-49c1-bb40-63b3b564df56"); // get student by id
//            studentRepo.deleteStudentByID("28019f8d-3377-49c1-bb40-63b3b564df56");  //  delete student by id




            // ---- testing Course ----//
//            CourseRepo courseRepo = new CourseRepo(); // postgres.DAL for course
//            courseRepo.createCourse(
//                    "math",
//                    Timestamp.valueOf("2023-8-8 11:20:20"),
//                    Timestamp.valueOf("2024-1-8 11:20:20"),
//                    Course.CourseLevel.advanced,
//                    true,
//                    1);
//            ArrayList<Course> courses = courseRepo.getAllCourses(); // get all courses
//            Course Course= courseRepo.getCourseByID(1); // get course by id
//            courseRepo.getCourseByID();  //  delete course by id
//            courseRepo.getCourseNameAndEnrolledStudents(UUID.fromString("73a51cfe-ef3b-49a8-86d8-e99b23d0a150"));
//            courseRepo.getCourseAndStudentsByLevel(Course.CourseLevel.beginner);
//            System.out.print(InstructorRepo.getInstructorByID(0));


            //      ---- TESTING HIBERNATE ----


            //Instructor

//            Instructor ins = new Instructor();
//            ins.setFirstName("instructor");
//            ins.setLastName("4");
//            ins.setEmail("instructor4@gmail.com");
//            ins.setPhoneNumber("011");
//            ins.setId(UUID.fromString("c8ad0689-b393-4ca9-b8a0-13a184538297"));
//
//            InstructorDAO insDAO = new InstructorDAO();
//            insDAO.save(ins); // CREATE INSTRUCTOR FROM AN OBJ --> DOESN'T WORK WITH PERSIST
//            Instructor  ins =  insDAO.getById(UUID.fromString("aca490ed-8c4a-4620-9977-7af1c12cbb57")); // GET BY ID
//            List<Instructor> instructors = insDAO.getAll(); //get all
//            insDAO.update(ins); // updates Instructor
//            insDAO.deleteById(UUID.fromString("c8ad0689-b393-4ca9-b8a0-13a184538297")); //Delete By ID
//            System.out.println(instructors.get(0).getEmail());




            //Course
//            Course cours = new Course();
//            cours.setId(UUID.fromString("dcf852f8-324d-444e-a20e-7f07c39541b6"));
//            cours.setCourseLevel(Course.CourseLevel.advanced);
//            cours.setStartDate(Timestamp.valueOf(LocalDate.now().atStartOfDay()));
//            cours.setEndDate(Timestamp.valueOf(LocalDate.now().atStartOfDay()));
//            cours.setName("algebra");
//            cours.setStarted(true);
//            cours.setInstructorID(UUID.fromString("7cb9707b-3bed-42ae-b49b-574f9fc369c8"));


//            CourseDAO courseDAO = new CourseDAO();
//            courseDAO.save(cours);
//            Course cours =  courseDAO.getById(UUID.fromString("1a397d89-38cb-4dcc-a953-986ccc5b616b")); // GET BY ID
//            List<Course> courses = courseDAO.getAll(); //get all
//            courseDAO.update(cours); // updates Instructor
//            courseDAO.deleteById(UUID.fromString("dcf852f8-324d-444e-a20e-7f07c39541b6")); //Delete By ID

//            System.out.println(cours.getName());
//            System.out.println(courses.get(0).getName());


            //Student
//            Student student = new Student();
//            student.setId(UUID.fromString("3cca1bfb-3233-47f0-8fdb-adc95f273291"));
//            student.setFirstName("student");
//            student.setLastName("2");
//            student.setAge(23);
//            student.setGender(Student.Gender.male);
//            student.setEmail("student2@Gmail.com");
//            student.setPhoneNumber("012");
//            student.setNatID("121461232");
//
//            StudentDAO studentDAO = new StudentDAO();
//            studentDAO.save(student);
//            Student student =  studentDAO.getById(UUID.fromString("890b47fb-13e4-44d3-b02c-a6b32a6945ed")); // GET BY ID
//            List<Student> students = studentDAO.getAll(); //get all
//            studentDAO.update(student); // updates Instructor
//            studentDAO.deleteById(UUID.fromString("3cca1bfb-3233-47f0-8fdb-adc95f273291")); //Delete By ID
//
//            System.out.println(students.get(0).getFirstName());







        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}