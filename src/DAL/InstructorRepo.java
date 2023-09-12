package DAL;

import models.Instructor;

import java.util.ArrayList;

public class InstructorRepo extends PostgresDataBase {

    public  ArrayList<Instructor>  getAllInstructors() throws ClassNotFoundException, NoSuchMethodException {
        return this.selectAll("Instructor");
    }
}
