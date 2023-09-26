package org.example;


import hibernate.entities.Course;
import hibernate.entities.Instructor;
import hibernate.entities.InstructorDetails;
import hibernate.entities.Student;
import hibernate.repositories.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Main {

    static void InstructorTesting(){

        //Instructor

//            Instructor ins = new Instructor();
//            ins.setFirstName("instructor");
//            ins.setLastName("6");
//            ins.setEmail("instructor6@gmail.com");
//            ins.setPhoneNumber("011");
//            ins.setId(UUID.fromString("c8ad0689-b393-4ca9-b8a0-13a184538297"));

//            InstructorRepository insRepo = new InstructorRepository();
//            insRepo.save(ins); // CREATE INSTRUCTOR FROM AN OBJ --> DOESN'T WORK WITH PERSIST
//            Instructor  ins =  insRepo.getById(UUID.fromString("aca490ed-8c4a-4620-9977-7af1c12cbb57")); // GET BY ID
//            List<Instructor> instructors = insRep.getAll(); //get all
//            insRepo.update(ins); // updates Instructor
//            insRepo.deleteById(UUID.fromString("c8ad0689-b393-4ca9-b8a0-13a184538297")); //Delete By ID
//            System.out.println(ins.toString());

    }
    static void CourseTesting(){

//            Course
//            Course cours = new Course();
//            cours.setId(UUID.fromString("dcf852f8-324d-444e-a20e-7f07c39541b6"));
//            cours.setCourseLevel(Course.CourseLevel.advanced);
//            cours.setStartDate(Timestamp.valueOf(LocalDate.now().atStartOfDay()));
//            cours.setEndDate(Timestamp.valueOf(LocalDate.now().atStartOfDay()));
//            cours.setName("algebra");
//            cours.setStarted(true);
//            cours.setInstructorID(UUID.fromString("7cb9707b-3bed-42ae-b49b-574f9fc369c8"));
//
//
            CourseRepository courseRepo = new CourseRepository();
//            courseRepo.save(cours);
            Course cours =  courseRepo.getById(UUID.fromString("1a397d89-38cb-4dcc-a953-986ccc5b616b")); // GET BY ID
//            List<Course> courses = courseRepo.getAll(); //get all
//            courseRepo.update(cours); // updates Instructor
//            courseRepo.deleteById(UUID.fromString("dcf852f8-324d-444e-a20e-7f07c39541b6")); //Delete By ID
//
            System.out.println(cours.toString());
//            System.out.println(courses.get(0).getName());

    }
    static void InstructorDetailsTest(){
//        InstructorRepository insRepo = new InstructorRepository();
//        Instructor ins = insRepo.getById(UUID.fromString("aca490ed-8c4a-4620-9977-7af1c12cbb57"));
//        InstructorDetails insDeta = new InstructorDetails("youtube.com/instructor3","al sba7ah",ins);
//        InstructorDetailsRepository repo = new InstructorDetailsRepository();
//        System.out.println(repo.getById(UUID.fromString("86092f6e-c33b-4f2b-aa14-57507a8616a2")).toString());

    }

    static void StudentTesting(){


//            Student
//            Student student = new Student();
//            student.setId(UUID.fromString("3cca1bfb-3233-47f0-8fdb-adc95f273291"));
//            student.setFirstName("student");
//            student.setLastName("2");
//            student.setAge(23);
//            student.setGender(Student.Gender.Male);
//            student.setEmail("student2@Gmail.com");
//            student.setPhoneNumber("012");
//            student.setNatID("121461232");
//
//            StudentRepository studentRepo = new StudentRepository();
//            studentRepo.save(student);
//            Student student =  studentRepo.getById(UUID.fromString("890b47fb-13e4-44d3-b02c-a6b32a6945ed")); // GET BY ID
//            List<Student> students = studentRepo.getAll(); //get all
//            studentRepo.update(student); // updates Instructor
//            studentRepo.deleteById(UUID.fromString("3cca1bfb-3233-47f0-8fdb-adc95f273291")); //Delete By ID

//            System.out.println(students);
    }
    public static void main(String[] args) {
        try{


            CourseTesting();
//            InstructorDetailsTest();
//            InstructorTesting();







        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}