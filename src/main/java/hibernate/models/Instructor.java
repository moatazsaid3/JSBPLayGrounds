package postgres.models;

import jakarta.persistence.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    public  Instructor(){

    }

    public Instructor(ResultSet rs) throws SQLException {
        while (rs.next()) {
            this.id = rs.getInt("id");
            this.firstName = rs.getString("firstName");
            this.lastName = rs.getString("lastName");
            this.email = rs.getString("email");
            this.phoneNumber = rs.getString("phoneNumber");
            System.out.println(id + "," + firstName + ","+ lastName+"," + email + "," + phoneNumber);
        }
    }
    void Instructor(int id, String firstName, String lastName, String email, String phoneNumber, String title){
         this.id = id;
         this.firstName = firstName;
         this.lastName = lastName;
         this.email = email;
         this.phoneNumber = phoneNumber ;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber(int i) {
        return phoneNumber;
    }
}
