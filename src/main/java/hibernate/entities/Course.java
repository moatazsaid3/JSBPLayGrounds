package hibernate.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "course")
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


    @ManyToOne()
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Course(){

    }


    public Course(UUID id, String name, Timestamp startDate, Timestamp endDate, CourseLevel courseLevel, boolean isStarted, Instructor instructor) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseLevel = courseLevel;
        this.isStarted = isStarted;
        this.instructor = instructor;
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

    public Instructor getInstructor() {
        return instructor;
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", courseLevel=" + courseLevel +
                ", isStarted=" + isStarted +
                ", instructor=" + instructor.toString() +
                '}';
    }


}