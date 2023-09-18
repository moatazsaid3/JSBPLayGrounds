package DAL;

import models.Instructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorRepo extends PostgresDataBase  {

    public  ArrayList<Instructor>  getAllInstructors() throws ClassNotFoundException, NoSuchMethodException {
        return this.selectAll("Instructor");
    }

    public <T> Instructor getInstructorByID(T id) throws ClassNotFoundException, NoSuchMethodException {
        return this.selectByID("Instructor", id) ;
    }
    public <T> void deleteInstructorByID(T id) throws ClassNotFoundException, NoSuchMethodException {
        this.deleteById("Instructor", id);
    }
    public void createInstructor(String firstName,String lastName,String email,String phoneNumber){
        final String  createInstanceQuery = "INSERT INTO instructor(firstName,lastName,email,phoneNumber)" +
                "VALUES ('" + firstName + "','" + lastName + "','" + email + "','" + phoneNumber + "');";

        this.executeQuery(createInstanceQuery);
    }
    public void getNameAndCourses(int id) throws SQLException {
        String getNameAndCoursesQuery = "SELECT i.firstName || ' ' || i.lastName AS fullName, c.name AS courseName FROM instructor i JOIN course c ON i.id = c.instructorID WHERE i.id = "+id+";";
        ResultSet rs = this.executeQueryResultSet(getNameAndCoursesQuery);
        while (rs.next()) {
            String fullName = rs.getString("fullName");
            String courseName = rs.getString("courseName");
            System.out.println( "Instructor's name :" + fullName + ", Course : " + courseName);
        }

    }

    public void getNameAndCoursesAndStudents(int id) throws SQLException {
        String getNameAndCoursesQuery = "SELECT i.firstName || ' ' || i.lastName AS fullName, s.firstName || ' ' || s.lastName AS studentName, c.name AS courseName\n" +
                "FROM instructor i\n" +
                "JOIN course c " +
                "ON i.id = c.instructorID " +
                "JOIN course_student sc " +
                "ON c.id = sc.courseid " +
                "JOIN student s " +
                "ON sc.studentid = s.id " +
                "where i.id = " + id + ";";
        ResultSet rs = this.executeQueryResultSet(getNameAndCoursesQuery);
        while (rs.next()) {
            String fullName = rs.getString("fullName");
            String courseName = rs.getString("courseName");
            String studentName = rs.getString("studentName");
            System.out.println( "Instructor's name :" + fullName + ", Course : " + courseName + ", Student : " + studentName);
        }

    }

}
