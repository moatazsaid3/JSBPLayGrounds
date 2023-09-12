package models;

import java.sql.Timestamp;
import java.util.UUID;

public class Course {

    // Declare the enum type for course level
    public enum CourseLevel {
        BEGINNER, ADVANCED, MIDDLE
    }

    // Declare the private fields for the class attributes
    private UUID id;
    private String name;
    private Timestamp start_date;
    private Timestamp end_date;
    private CourseLevel course_level;
    private boolean is_started;
    private UUID instructor_id;

    // Create a constructor with parameters for all the fields
    public Course(UUID id, String name, Timestamp start_date, Timestamp end_date, CourseLevel course_level, boolean is_started, UUID instructor_id) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.course_level = course_level;
        this.is_started = is_started;
        this.instructor_id = instructor_id;
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
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public CourseLevel getCourse_level() {
        return course_level;
    }

    public void setCourse_level(CourseLevel course_level) {
        this.course_level = course_level;
    }

    public boolean isIs_started() {
        return is_started;
    }

    public void setIs_started(boolean is_started) {
        this.is_started = is_started;
    }

    public UUID getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(UUID instructor_id) {
        this.instructor_id = instructor_id;
    }
}