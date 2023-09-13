package DAL;

import models.Course;
import models.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

public class CourseRepo extends PostgresDataBase {

    //Select
    public ArrayList<Course> getAllCourses() throws ClassNotFoundException, NoSuchMethodException {
        return this.selectAll("Course");
    }
    public <T> Course getCourseByID(T id) throws ClassNotFoundException, NoSuchMethodException {
        return this.selectByID("Course", id) ;
    }
    //delete
    public <T> void deleteCourseByID(T id) throws ClassNotFoundException, NoSuchMethodException {
        this.deleteById("Course",id);
    }
    //Insert
    public void createCourse(String name, Timestamp startDate, Timestamp endDate, Course.CourseLevel courseLevel, boolean isStarted, int instructorID){
        final String  createInstanceQuery = "INSERT INTO course(id, name, startDate, endDate, courseLevel, isStarted, instructorID)" +
                "VALUES ('" + UUID. randomUUID() + "','" + name + "','" + startDate + "','" + endDate + "','" + courseLevel + "'," + isStarted + "," + instructorID + ");";
        this.executeQuery(createInstanceQuery);
    }
    public void getCourseNameAndEnrolledStudents(UUID id) throws SQLException {
        String getNameAndCoursesQuery = "SELECT c.name AS courseName, c.startDate AS startDate, s.firstName || ' ' || s.lastName AS studentName FROM course c JOIN course_student sc ON c.id = sc.courseID JOIN student s ON sc.studentID = s.id;";
        ResultSet rs = this.executeQueryResultSet(getNameAndCoursesQuery);
        while (rs.next()) {
            String courseName = rs.getString("courseName");
            Timestamp startDate = rs.getTimestamp("startDate");
            String studentName = rs.getString("studentName");

            System.out.println( "Course : " + courseName + ", start date: " + startDate + ", student name : " + studentName );
        }

    }
    public void getCourseAndStudentsByLevel(Course.CourseLevel CL) throws SQLException {
        String getNameAndCoursesQuery = "SELECT s.firstName || ' ' || s.lastName AS studentName, c.name AS courseName " +
                "FROM course c " +
                "JOIN course_student sc " +
                "ON c.id = sc.courseID " +
                "JOIN student s " +
                "ON sc.studentID = s.id " +
                "WHERE c.courseLevel = '" + CL +"';";
        ResultSet rs = this.executeQueryResultSet(getNameAndCoursesQuery);
        while (rs.next()) {
            String courseName = rs.getString("courseName");
            String studentName =  rs.getString("studentName");

            System.out.println( "Course : " + courseName + ", student name : " + studentName + ", course Level : " + CL);
        }
    }
}
