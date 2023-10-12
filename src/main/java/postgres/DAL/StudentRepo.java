package postgres.DAL;

import models.Student;

import java.util.ArrayList;
import java.util.UUID;

public class StudentRepo extends PostgresDataBase {

    //Select
    public ArrayList<Student> getAllStudents() throws ClassNotFoundException, NoSuchMethodException {
        return this.selectAll("Student");
    }
    public <T> Student getStudentByID(T id) throws ClassNotFoundException, NoSuchMethodException {
        return this.selectByID("Student", id) ;
    }
    //delete
    public <T> void deleteStudentByID(T id) throws ClassNotFoundException, NoSuchMethodException {
        this.deleteById("Student",id);
    }
    //Insert
    public void createStudent(String firstName, String lastName, int age, Student.Gender gender, String email, String phoneNumber, long natID){
        final String  createInstanceQuery = "INSERT INTO student(id, firstName,lastName, age, gender,email, phoneNumber, natID)" +
                "VALUES ('" + UUID. randomUUID() + "','" + firstName + "','" + lastName + "'," + age + ",'" + gender + "','" + email + "'," + phoneNumber + "," + natID +  ");";

        this.executeQuery(createInstanceQuery);
    }

}
