package hibernate.entities;


import jakarta.persistence.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Entity
@Table(name = "student")
public class Student {



    // Declare the enum type for gender
    public enum Gender {
        Male, Female;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "student_first_name")
    private String firstName;
    @Column(name = "student_last_name")
    private String lastName;
    @Column(name = "student_age")
    private int age;
    @Column(name = "student_gender")
    private Gender gender;
    @Column(name = "student_email")
    private String email;
    @Column(name = "student_phone_number")
    private String phoneNumber;
    @Column(name = "student_nat_id")
    private long natID;
    public Student() {

    }

    public Student(UUID id, String firstName, String lastName, int age, Gender gender, String email, String phoneNumber, long natID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.natID = natID;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public long getNatID() {
        return natID;
    }

    public void setNatID(long natID) {
        this.natID = natID;
    }

}
