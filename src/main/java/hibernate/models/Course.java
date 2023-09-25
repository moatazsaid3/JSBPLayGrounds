package hibernate.models;

import hibernate.models.Instructor;
import jakarta.persistence.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "COURSE")
public class Course {

    // Declare the enum type for course level
    public enum CourseLevel {
        beginner, advanced, middle
    }

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "course_name")
    private String name;

    @Column(name = "course_start_date")
    private Timestamp startDate;

    @Column(name = "course_end_date")
    private Timestamp endDate;

    @Column(name = "course_level")
    @Enumerated(EnumType.STRING)
    private CourseLevel courseLevel;

    @Column(name = "course_started")
    private boolean isStarted;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "instructor_id")
    @Column(name = "instructor_id")
    private UUID instructorID;

    public Course(){

    }

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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public CourseLevel getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(CourseLevel courseLevel) {
        this.courseLevel = courseLevel;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public UUID getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(UUID instructorID) {
        this.instructorID = instructorID;
    }
}