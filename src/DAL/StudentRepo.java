package DAL;

import models.Student;

import java.util.ArrayList;

public class StudentRepo extends PostgresDataBase {
    public ArrayList<Student> getAllStudents() throws ClassNotFoundException, NoSuchMethodException {
        return this.selectAll("Student");
    }
}
