
import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //ArrayList<Instructor> instructors =  PostgresDataBase.selectAll("instructor"); // --> selects all instructors
        //Instructor instructor = PostgresDataBase.selectByID("instructor",1); // --> selects one isntructor by id
        try{
           ArrayList<Instructor> instructors = PostgresDataBase.selectAll("Instructor");

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}