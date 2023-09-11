
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



public class Main {

    public static void main(String[] args)
    {
        PostgresDataBase  DB = new PostgresDataBase();
        PostgresDataBase.selectAll("Instructor");

    }
}