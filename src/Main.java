
import DAL.CourseRepo;
import DAL.InstructorRepo;
import DAL.PostgresDataBase;
import DAL.StudentRepo;
import models.Course;
import models.Instructor;
import models.Student;

import java.sql.Timestamp;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try{

            // ---- testing Instructor ----//
            InstructorRepo InstructorRepo = new InstructorRepo() ; // DAL for instructor
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
            StudentRepo studentRepo = new StudentRepo(); // DAL for student
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
            CourseRepo courseRepo = new CourseRepo(); // DAL for course
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


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}