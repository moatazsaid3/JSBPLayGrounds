package hibernate.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class StudentDTO {

    // Declare the enum type for gender
    public enum Gender {
        Male, Female
    }

    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String email;
    private String phoneNumber;
    private long natID;

    public StudentDTO(ResultSet rs) throws SQLException {
        while (rs.next()) {


            this.id = (UUID) rs.getObject("id");
            this.firstName = rs.getString("firstName");
            this.lastName = rs.getString("lastName");
            this.age = rs.getInt("age");;
            this.gender = Gender.valueOf(rs.getString("gender"));
            this.email = rs.getString("email");
            this.phoneNumber = rs.getString("phoneNumber");;
            this.natID = rs.getLong("natID");;
            System.out.println(id + "," + firstName + ","+ lastName+"," + email + "," + phoneNumber);
        }
    }
    public StudentDTO(UUID id, String firstName, String lastName, int age, Gender gender, String email, String phoneNumber, long natID) {

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
        // Check if the age is positive
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be positive");
        }
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
        if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email must be valid");
        }
    }

    public String getPhoneNum() {
        return phoneNumber;
    }

    public void setPhoneNum(String phoneNumber) {
        if (phoneNumber.matches("^\\+?[0-9]{10,15}$")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Phone number must be valid");
        }
    }

    public long getNatId() {
        return natID;
    }

    public void setNatId(long natId) {
        this.natID = natId;
    }
}
