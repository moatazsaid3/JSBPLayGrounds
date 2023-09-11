
import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Access modifiers
//Default -> is visible in its package
//public -> is visible everywhere
//private -> is visible only in the class
//protected -> is visible in the package and by the subclasses


// Java code for thread creation by extending
// the Thread class
//
//final String  createTable = "CREATE TABLE instructor (" +
//        "\t id serial PRIMARY KEY NOT NULL," +
//        "\t firstName VARCHAR(50) NOT NULL," +
//        "\t lastName  VARCHAR(50) NOT NULL," +
//        "\t email     VARCHAR(255) NOT NULL," +
//        "\t phoneNumber VARCHAR(22) NOT NULL" +
//        "\t );";
//
//final String  insertIntable = "INSERT INTO instructor(firstName,lastName,email,phoneNumber)\n" +
//        "VALUES ('ahmed','said','ahmed@gmail.com','011');";
//final String selectFromTable = "select * from instructor;";


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