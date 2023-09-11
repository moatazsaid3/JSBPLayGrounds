
import java.sql.*;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class PostgresDataBase{
    private final static String url = "jdbc:postgresql://localhost/center_management";
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

    static <T> T selectByID(String tableName, int id) {
        final String selectFromTableByID = "select * from " + tableName + " where id = " + id + ";";

        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(selectFromTableByID)
        ){
            Class c = Class.forName(tableName);
            Constructor constructor = c.getConstructor(ResultSet.class);

            return  (T)constructor.newInstance(rs);
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    static <T> ArrayList<T> selectAll(String tableName) throws ClassNotFoundException, NoSuchMethodException {

        final String selectAllFromTable = "select * from " + tableName + ";";

        Class c = Class.forName(tableName);
        Constructor constructor = c.getConstructor(ResultSet.class);



        //System.out.println(selectFromTable);
        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(selectAllFromTable);

        ){
            ArrayList<T> objects =new ArrayList<>();
            while (rs.next()) {
                objects.add((T) constructor.newInstance(rs));
            }
           return  objects;
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

}



