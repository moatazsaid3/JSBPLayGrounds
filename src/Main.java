
import DAL.InstructorRepo;
import DAL.PostgresDataBase;
import models.Instructor;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //ArrayList<Instructor> instructors =  DAL.PostgresDataBase.selectAll("instructor"); // --> selects all instructors
        //Instructor instructor = DAL.PostgresDataBase.selectByID("instructor",1); // --> selects one isntructor by id
        try{
            InstructorRepo ins = new InstructorRepo() ;
            ArrayList<Instructor> instructors = ins.getAllInstructors();
//            ArrayList<Instructor> instructors = InstructorRepo.selectAll("Instructor");
            //ArrayList<Student> Students = DAL.PostgresDataBase.selectAll("Student");

            //Instructor instructor = DAL.PostgresDataBase.selectByID("Instructor",1); // --> selects one instructor by id
            //Student student  = DAL.PostgresDataBase.selectByID("Student","73314cf4-3050-409d-8138-9e2d0530cf0c"); // --> selects one instructor by id

            //DAL.PostgresDataBase.deleteById("Student", "73314cf4-3050-409d-8138-9e2d0530cf0c");

        } catch (
//                ClassNotFoundException | NoSuchMethodException e
        Exception e
        ) {
            e.printStackTrace();
        }
    }
}