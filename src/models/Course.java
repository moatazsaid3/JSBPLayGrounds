package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

public class Course {

    // Declare the enum type for course level
    public enum CourseLevel {
        beginner, advanced, middle
    }

    // Declare the private fields for the class attributes
    private UUID id;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private CourseLevel courseLevel;
    private boolean isStarted;
    private int instructorID;

    public Course(ResultSet rs) throws SQLException {
        while (rs.next()) {


            this.id = (UUID) rs.getObject("id");
            this.name = rs.getString("name");
            this.startDate = rs.getTimestamp("startDate");
            this.endDate = rs.getTimestamp("endDate");;
            this.courseLevel = CourseLevel.valueOf(rs.getString("courseLevel"));
            this.isStarted = rs.getBoolean("isStarted");
            this.instructorID = rs.getInt("instructorID");;
            System.out.println(id + "," + name + ","+ startDate+"," + endDate + "," + courseLevel + "," + isStarted + "," + instructorID );
        }
    }
    // Create a constructor with parameters for all the fields
    public Course(UUID id, String name, Timestamp startDate, Timestamp endDate, CourseLevel courseLevel, boolean isStarted, int instructorID) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseLevel = courseLevel;
        this.isStarted = isStarted;
        this.instructorID = instructorID;
    }

    // Create getters and setters for all the fields
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getStart_date() {
        return startDate;
    }

    public void setStart_date(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEnd_date() {
        return endDate;
    }

    public void setEnd_date(Timestamp endDate) {
        this.endDate = endDate;
    }

    public CourseLevel getCourse_level() {
        return courseLevel;
    }

    public void setCourse_level(CourseLevel course_level) {
        this.courseLevel = course_level;
    }

    public boolean isIs_started() {
        return isStarted;
    }

    public void setIs_started(boolean is_started) {
        this.isStarted = is_started;
    }

    public int getInstructor_id() {
        return instructorID;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructorID= instructor_id;
    }
}