package hibernate.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Set;
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

    @ManyToOne()
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    Set<Student> students ;


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

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {

        return "Course{" + "\n" +
                "id=" + id + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", startDate=" + startDate + "\n" +
                ", endDate=" + endDate + "\n" +
                ", courseLevel=" + courseLevel + "\n" +
                ", isStarted=" + isStarted + "\n" +
                ", instructor=" + instructor.getFirstName()+" "+ instructor.getLastName() + "\n" +
                ", students=" + students +
                '}';
    }
}