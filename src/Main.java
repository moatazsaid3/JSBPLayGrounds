
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
    private final static String url = "jdbc:postgresql://localhost/playgrounds";
    private final static String user = "postgres";
    private final static String password = "#Postgres@MS123";

    static public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    public static void main(String[] args)
    {
        Connection connection = connect();

         final String  createTable = "CREATE TABLE instructor (" +
                "\t id serial PRIMARY KEY NOT NULL," +
                "\t firstName VARCHAR(50) NOT NULL," +
                "\t lastName  VARCHAR(50) NOT NULL," +
                "\t email     VARCHAR(255) NOT NULL," +
                "\t phoneNumber VARCHAR(22) NOT NULL" +
                "\t );";

        final String  insertIntable = "INSERT INTO instructor(firstName,lastName,email,phoneNumber)\n" +
                "VALUES ('ahmed','said','ahmed@gmail.com','011');";
        final String selectFromTable = "select * from instructor;";
        try (
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(selectFromTable)
        ){
                //System.out.println(rs.);

           //statement.executeUpdate(insertIntable) //-> to avoid no return queries throwing errors

            // one way to execute queries
//            Statement statement = connection.createStatement();
//            statement.addBatch(createTable);
//            statement.executeBatch();


        } catch ( Exception ex) {
            ex.printStackTrace();
        }


    }
}