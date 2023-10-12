package hibernate.entities;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy="instructor",fetch = FetchType.EAGER)
    private Set<Course> courses;
    @OneToOne(mappedBy = "instructor", fetch = FetchType.EAGER)
    private InstructorDetails details;

    public  Instructor(){

    }
    public Instructor(UUID id, String firstName, String lastName, String email, String phoneNumber, Set<Course> courses, InstructorDetails details) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.courses = courses;
        this.details = details;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Instructor{" + "\n" +
                "id=" + id +"\n" +
                ", firstName='" + firstName + '\'' +"\n" +
                ", lastName='" + lastName + '\'' +"\n" +
                ", email='" + email + '\'' +"\n" +
                ", phoneNumber='" + phoneNumber + '\'' +"\n" +
                ", courses=" + courses +"\n" +
                ", details=" + details +"\n" +
                '}';
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public InstructorDetails getDetails() {
        return details;
    }
}
