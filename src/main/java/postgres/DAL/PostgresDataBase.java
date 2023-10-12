package postgres.DAL;

import java.lang.reflect.Constructor;
import java.sql.*;
import java.util.ArrayList;

public abstract class PostgresDataBase{
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

    static <T,d> T selectByID(String tableName, d id) {
        String selectFromTableByIDQuery ="";
        if(id.getClass().getSimpleName().equals("String")){
              selectFromTableByIDQuery = "select * from " + tableName + " where id = '" + id.toString() + "';";

        }else{
              selectFromTableByIDQuery = "select * from " + tableName + " where id = " + id + ";";
        }

        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(selectFromTableByIDQuery)
        ){
            Class c = Class.forName("models." + tableName);
            Constructor constructor = c.getConstructor(ResultSet.class);

            return  (T)constructor.newInstance(rs);
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    static <T> ArrayList<T> selectAll(String tableName) throws ClassNotFoundException, NoSuchMethodException {
        final String selectAllFromTableQuery = "select * from " + tableName + ";";

        Class c = Class.forName("models." + tableName);
        Constructor constructor = c.getConstructor(ResultSet.class);

        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(selectAllFromTableQuery);
        ){
            ArrayList<T> objects =new ArrayList<>();

            objects.add((T) constructor.newInstance(rs));
            while (rs.next()) {
                objects.add((T) constructor.newInstance(rs));
            }
           return  objects;
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    static <T> void deleteById(String tableName, T id) throws ClassNotFoundException, NoSuchMethodException {
        String deleteFromTableByIDQuery ="";
        if(id.getClass().getSimpleName().equals("String")){
            deleteFromTableByIDQuery = "delete from " + tableName + " where id = '" + id.toString() + "';";

        }else{
            deleteFromTableByIDQuery = "delete from " + tableName + " where id = " + id.toString() + ";";
        }


        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(deleteFromTableByIDQuery);
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
    }
    static void executeQuery(String Query){
        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(Query);
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
    }
    static ResultSet executeQueryResultSet(String Query){
        try (
                Connection connection = connect();
        ){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Query);
            return rs;
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}



