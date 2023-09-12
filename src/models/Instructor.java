package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Instructor {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String title;



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
         this.title = title;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTitle() {
        return title;
    }
}
